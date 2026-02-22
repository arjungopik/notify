package com.notification_service.notify.service;

import com.notification_service.notify.domain.entity.User;
import com.notification_service.notify.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(String name, String email) {
        User user = new User(name, email);
        User savedUser = userRepository.save(user);
        LOGGER.info("User created successfully with id: {}", savedUser.getId());
        return savedUser != null;
    }

}
