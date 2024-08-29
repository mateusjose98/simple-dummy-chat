package org.mateusjose98.simplechat.dto;

import lombok.Data;

@Data
public class SendMessageRequestDTO {

    private Long conversationId;
    private Long senderId;
    private String message;


}
