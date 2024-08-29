package org.mateusjose98.simplechat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ConversationDTO {

    private String title;
    private Long creatorId;
    private List<Long> participants;

}
