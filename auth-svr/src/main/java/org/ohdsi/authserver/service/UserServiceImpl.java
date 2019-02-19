package org.ohdsi.authserver.service;

import org.ohdsi.authserver.model.User;
import org.ohdsi.authserver.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @Override
    public User get(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public User getOrCreate(String username) {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            user = userRepository.saveAndFlush(new User(username));
        }
        return user;
    }
}
