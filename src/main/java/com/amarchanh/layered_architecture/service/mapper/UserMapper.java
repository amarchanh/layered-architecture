package com.amarchanh.layered_architecture.service.mapper;

import com.amarchanh.layered_architecture.repository.entities.UserEntity;
import com.amarchanh.layered_architecture.service.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserEntity toEntity(User user);

    User toModel(UserEntity entity);

    List<User> toModelList(List<UserEntity> entityList);
}
