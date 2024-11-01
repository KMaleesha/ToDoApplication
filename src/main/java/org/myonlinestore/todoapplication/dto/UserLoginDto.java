package org.myonlinestore.todoapplication.dto;

import lombok.Data;

@Data
public class UserLoginDto {

    private int id;
    private String username;
    private String email;
    private String password;
}
