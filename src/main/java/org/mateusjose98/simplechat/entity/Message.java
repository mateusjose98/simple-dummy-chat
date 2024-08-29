package org.mateusjose98.simplechat.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Users sender;
    @ManyToOne
    private Conversation conversation;
    private String content;
    private Instant createdAt;


}
