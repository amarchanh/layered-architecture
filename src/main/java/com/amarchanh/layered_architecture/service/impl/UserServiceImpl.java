package com.amarchanh.layered_architecture.service.impl;

import com.amarchanh.layered_architecture.repository.UserRepository;
import com.amarchanh.layered_architecture.service.UserService;
import com.amarchanh.layered_architecture.service.exceptions.UserNotFoundException;
import com.amarchanh.layered_architecture.service.mapper.UserMapper;
import com.amarchanh.layered_architecture.service.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public User saveUser(User user) {
        log.info("Storing user into database...");
        final var entity = this.userMapper.toEntity(user);
        return this.userMapper.toModel(this.userRepository.save(entity));
    }

    @Override
    public User findUser(Long id) {
        return this.userMapper.toModel(this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public List<User> findUsers() {
        return this.userMapper.toModelList(this.userRepository.findAll());
    }
}
