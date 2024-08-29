package org.mateusjose98.simplechat.service;

import lombok.RequiredArgsConstructor;
import org.mateusjose98.simplechat.entity.Conversation;
import org.mateusjose98.simplechat.entity.Message;
import org.mateusjose98.simplechat.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    @Transactional
    public void save(Message message) {
        message.setCreatedAt(Instant.now());
        messageRepository.save(message);
    }

    public List<Message> findByConversation(Conversation conversation) {
        return messageRepository.findByConversation(conversation);
    }
}
