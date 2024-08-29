package org.mateusjose98.simplechat.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
public class UserConversation implements Serializable {
    @EmbeddedId
    private UserConversationPK id;
    private Instant joinedAt;

    public UserConversation(Users participant, Conversation conversation) {
        this.id = new UserConversationPK(participant, conversation);
        this.joinedAt = Instant.now();
    }
}
