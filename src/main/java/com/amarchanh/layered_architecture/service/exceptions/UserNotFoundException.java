package com.amarchanh.layered_architecture.service.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("User with id " + id + " not found in database.");
    }
}
