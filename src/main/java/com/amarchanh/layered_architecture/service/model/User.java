package com.amarchanh.layered_architecture.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;

    private String firstName;

    private String lastName;

}
