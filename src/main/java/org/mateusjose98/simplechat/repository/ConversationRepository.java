package org.mateusjose98.simplechat.repository;

import org.mateusjose98.simplechat.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    @Query(value = """
            SELECT U.NAME, M.CONTENT, M.CREATED_AT FROM MESSAGE M
            INNER JOIN USERS U ON
            U.ID = M.SENDER_ID
            WHERE CONVERSATION_ID = ?1
            """, nativeQuery = true)
    List<Object[]> findMessagesByConversationId(Long conversationId);
}
