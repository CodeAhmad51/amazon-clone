package com.amazon.entities;

import com.amazon.dto.UserDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "users")
@Data
public class User {

    @Id
    private UUID id;

    private String password;

    private String firstName;

    private String lastName;

    private String mobile;

    private String email;

    public UserDto toDto(){
        UserDto dto = new UserDto();

        dto.setFirstName(this.getFirstName());
        dto.setLastName(this.getLastName());
        dto.setEmail(this.getEmail());
        dto.setMobile(this.getMobile());
        dto.setId(this.getId());

        return dto;
    }

}
