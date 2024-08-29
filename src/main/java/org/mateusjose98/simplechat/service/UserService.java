package org.mateusjose98.simplechat.service;

import lombok.RequiredArgsConstructor;
import org.mateusjose98.simplechat.repository.UserRepository;
import org.mateusjose98.simplechat.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public List<Users> findAllByIds(List<Long> ids) {
        return userRepository.findAllById(ids);
    }

    public Optional<Users> findById(Long senderId) {
        return userRepository.findById(senderId);
    }

    public Users getByReference(Long creatorId) {
        return userRepository.getReferenceById(creatorId);
    }
}
