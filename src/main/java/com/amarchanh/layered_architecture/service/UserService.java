package com.amarchanh.layered_architecture.service;

import com.amarchanh.layered_architecture.service.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User findUser(Long id);

    List<User> findUsers();
}
