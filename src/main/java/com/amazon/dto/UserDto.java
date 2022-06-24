package com.amazon.dto;

import com.amazon.entities.User;
import lombok.Data;

import java.util.UUID;


@Data
public class UserDto {

    private UUID id;

    private String password;

    private String firstName;

    private String lastName;

    private String mobile;

    private String email;

    public User toEntity(){

        User user = new User();

        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());
        user.setMobile(this.getMobile());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        user.setId(this.getId());

        return user;
    }
}
