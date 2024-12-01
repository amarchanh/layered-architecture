package com.amarchanh.layered_architecture.rest;

import com.amarchanh.layered_architecture.rest.dtos.UserRequest;
import com.amarchanh.layered_architecture.rest.dtos.UserResponse;
import com.amarchanh.layered_architecture.rest.mapper.UserControllerMapper;
import com.amarchanh.layered_architecture.service.UserService;
import com.amarchanh.layered_architecture.service.exceptions.UserNotFoundException;
import com.amarchanh.layered_architecture.service.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserControllerMapper userMapper;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> saveUser(@RequestBody @Valid final UserRequest userRequest) {
        try {
            User response = this.userService.saveUser(this.userMapper.toModel(userRequest));
            return ResponseEntity.created(URI.create("/userCreated")).body(this.userMapper.toResponse(response));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable final Long id) {
        try {
            final User user = this.userService.findUser(id);
            return ResponseEntity.ok(this.userMapper.toResponse(user));
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers(@PathVariable final Long id) {
        try {
            final List<User> users = this.userService.findUsers();
            return ResponseEntity.ok(this.userMapper.toResponseList(users));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
