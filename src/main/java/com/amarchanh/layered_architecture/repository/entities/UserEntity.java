package com.amarchanh.layered_architecture.repository.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String last_name;

}
