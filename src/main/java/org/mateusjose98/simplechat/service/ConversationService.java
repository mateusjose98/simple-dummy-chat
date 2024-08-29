package org.mateusjose98.simplechat.service;

import lombok.RequiredArgsConstructor;
import org.mateusjose98.simplechat.dto.ConversationDetailsDTO;
import org.mateusjose98.simplechat.entity.Message;
import org.mateusjose98.simplechat.mappers.ConversationMapper;
import org.mateusjose98.simplechat.repository.ConversationRepository;
import org.mateusjose98.simplechat.dto.ConversationDTO;
import org.mateusjose98.simplechat.entity.Conversation;
import org.mateusjose98.simplechat.entity.UserConversation;
import org.mateusjose98.simplechat.entity.Users;
import org.mateusjose98.simplechat.repository.rowmappers.MessageDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final UserService userService;
    private final UserConversationService userConversationService;
    private final MessageService messageService;

    @Transactional
    public Long createConversation(ConversationDTO conversationDto) {
        List<Users> participants = userService.findAllByIds(conversationDto.getParticipants());
        Conversation conversation = conversationRepository.save(ConversationMapper.toEntity(conversationDto, userService.getByReference(conversationDto.getCreatorId())));
        for (Users participant : participants) {
            UserConversation relation = new UserConversation(participant, conversation);
            userConversationService.save(relation);
        }
        return conversation.getId();

    }
    @Transactional
    public void sendMessage(Long conversationId, Long senderId, String content) {
        Conversation conversation = conversationRepository.findById(conversationId).orElseThrow();
        Users sender = userService.findById(senderId).orElseThrow();
        var users = userConversationService.findByAllUsersByConversation(conversation);
        if (users.stream().noneMatch(userConversation -> userConversation.getId().getUser().equals(sender))) {
            throw new RuntimeException("User is not part of the conversation");
        }
        Message message = new Message();
        message.setConversation(conversation);
        message.setSender(sender);
        message.setContent(content);
        messageService.save(message);
    }

    public Optional<ConversationDetailsDTO> findDetails(Long id) {
        Conversation conversation = conversationRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Conversation not found");
        });
        Set<MessageDto> messages = conversationRepository.findMessagesByConversationId(id).stream()
                .map(MessageDto::new).collect(Collectors.toSet());
        if (messages.isEmpty()) {
            return Optional.empty();
        } else {
            ConversationDetailsDTO dto = new ConversationDetailsDTO();
            dto.setConversationId(id);
            dto.setTitle(conversation.getTitle());
            dto.setCreatorName(conversation.getCreator().getName());
            dto.setMessages(messages);
            return Optional.of(dto);
        }
    }
}
