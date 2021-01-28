package com.example.springtest.service;

import com.example.springtest.dao.entity.User;
import com.example.springtest.dao.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GreetingService greetingService;

    public UserServiceImpl(UserRepository userRepository, GreetingService greetingService) {
        this.userRepository = userRepository;
        this.greetingService = greetingService;
    }

    @Override
    public User getUserByUserName(String name) {
        User userByName = userRepository.findUserByName(name);
        if (userByName == null) {
            return new User("Guest", null, null);
        }
        String tempPassword = greetingService.createTempPassword(userByName.getName());
        return new User(userByName.getName(), tempPassword, userByName.getUserId());
    }
}
