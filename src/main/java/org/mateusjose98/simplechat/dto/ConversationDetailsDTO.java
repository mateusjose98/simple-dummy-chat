package org.mateusjose98.simplechat.dto;

import lombok.Data;
import org.mateusjose98.simplechat.entity.Conversation;
import org.mateusjose98.simplechat.entity.Message;
import org.mateusjose98.simplechat.entity.UserConversation;
import org.mateusjose98.simplechat.repository.rowmappers.MessageDto;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ConversationDetailsDTO {
    private Long conversationId;
    private String title;
    private String creatorName;
    private Set<MessageDto> messages = new HashSet<>();

}
