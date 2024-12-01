package com.amarchanh.layered_architecture.rest.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;

    private String firstName;

    private String lastName;
}
