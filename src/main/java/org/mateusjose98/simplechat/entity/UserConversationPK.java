package org.mateusjose98.simplechat.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserConversationPK implements Serializable {
    @ManyToOne
    private Users user;
    @ManyToOne
    private Conversation conversation;


}
