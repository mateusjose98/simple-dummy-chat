package org.mateusjose98.simplechat.mappers;

import org.mateusjose98.simplechat.dto.ConversationDTO;
import org.mateusjose98.simplechat.entity.Conversation;
import org.mateusjose98.simplechat.entity.Users;

import java.time.Instant;
import java.util.stream.Collectors;

public class ConversationMapper {

//    public static ConversationDTO toDTO(Conversation conversation) {
//        ConversationDTO dto = new ConversationDTO();
//        dto.setTitle(conversation.getTitle());
//        dto.setCreatorId(conversation.getCreator().getId());
//        dto.setParticipants(conversation.getParticipants().stream().map(User::getId).collect(Collectors.toList()));
//        return dto;
//    }

    public static Conversation toEntity(ConversationDTO dto, Users creator) {
        Conversation conversation = new Conversation();
        conversation.setCreatedAt(Instant.now());
        conversation.setTitle(dto.getTitle());
        conversation.setCreator(creator);
        return conversation;
    }
}
