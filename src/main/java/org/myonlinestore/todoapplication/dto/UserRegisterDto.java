package org.myonlinestore.todoapplication.dto;

import lombok.Data;

@Data
public class UserRegisterDto {

    private int id;
    private String username;
    private String email;
    private String password;

}
