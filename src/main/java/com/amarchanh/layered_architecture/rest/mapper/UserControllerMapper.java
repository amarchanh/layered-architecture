package com.amarchanh.layered_architecture.rest.mapper;

import com.amarchanh.layered_architecture.rest.dtos.UserRequest;
import com.amarchanh.layered_architecture.rest.dtos.UserResponse;
import com.amarchanh.layered_architecture.service.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserControllerMapper {

    User toModel(UserRequest request);

    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> model);
}
