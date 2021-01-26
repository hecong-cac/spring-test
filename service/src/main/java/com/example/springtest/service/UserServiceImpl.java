package com.example.springtest.service;

import com.example.springtest.dao.entity.User;
import com.example.springtest.dao.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUserName(String name) {
        return userRepository.findUserByName(name);

    }
}
