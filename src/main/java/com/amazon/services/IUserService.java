package com.amazon.services;

import com.amazon.dto.UserDto;

import java.util.UUID;

public interface IUserService {

    UserDto saveUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    boolean deleteUser(UUID id);

    UserDto findUser(UUID id);


}
