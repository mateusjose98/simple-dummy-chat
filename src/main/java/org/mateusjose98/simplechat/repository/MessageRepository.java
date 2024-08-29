package org.mateusjose98.simplechat.repository;

import org.mateusjose98.simplechat.entity.Conversation;
import org.mateusjose98.simplechat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByConversation(Conversation conversation);
}
