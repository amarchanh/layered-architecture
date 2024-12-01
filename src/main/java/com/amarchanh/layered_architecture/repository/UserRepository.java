package com.amarchanh.layered_architecture.repository;

import com.amarchanh.layered_architecture.repository.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
