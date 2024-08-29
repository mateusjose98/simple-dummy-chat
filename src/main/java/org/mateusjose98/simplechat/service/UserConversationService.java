package org.mateusjose98.simplechat.service;

import lombok.RequiredArgsConstructor;
import org.mateusjose98.simplechat.entity.Conversation;
import org.mateusjose98.simplechat.entity.UserConversation;
import org.mateusjose98.simplechat.entity.Users;
import org.mateusjose98.simplechat.repository.UserConversationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserConversationService {
    private final UserConversationRepository userConversationRepository;
    @Transactional
    public void save(UserConversation userConversation) {
        userConversationRepository.save(userConversation);
    }

    public Optional<UserConversation> findByUserAndConversation(Users user, Conversation conversation) {
        return userConversationRepository.findByIdUserAndIdConversation(user, conversation);
    }

    public List<UserConversation> findByAllUsersByConversation(Conversation conversation) {
        return userConversationRepository.findByConversation(conversation);
    }
}
