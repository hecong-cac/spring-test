package com.example.springtest.service;

import com.example.springtest.dao.entity.User;

public interface UserService {
    User getUserByUserName(String name);
}
