package org.mateusjose98.simplechat.repository;

import org.mateusjose98.simplechat.entity.Conversation;
import org.mateusjose98.simplechat.entity.UserConversation;
import org.mateusjose98.simplechat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserConversationRepository extends JpaRepository<UserConversation, Long> {

    @Query("SELECT uc FROM UserConversation uc WHERE uc.id.user = ?1 AND uc.id.conversation = ?2")
    Optional<UserConversation> findByIdUserAndIdConversation(Users user, Conversation conversation);

    @Query("SELECT uc FROM UserConversation uc WHERE uc.id.conversation = ?1")
    List<UserConversation> findByConversation(Conversation conversation);
}
