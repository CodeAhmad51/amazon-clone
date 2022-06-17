package com.amazon.services;

import com.amazon.dto.UserDto;
import com.amazon.exception.InvalidUserException;
import com.amazon.repository.IUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository repository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        if(StringUtils.isBlank(userDto.getFirstName())){
            throw new InvalidUserException("User.First name can not be empty");
        }
        if(StringUtils.isBlank(userDto.getPassword())){
            throw new InvalidUserException("User.password can not be empty");
        }

        if(StringUtils.isBlank(userDto.getEmail()) && StringUtils.isBlank(userDto.getMobile()) ){
            throw new InvalidUserException("User.Email or User.mobile both can not be empty");
        }
        if( userDto.getMobile().length() != 10){
            throw new InvalidUserException("User.mobile should be 10 digit");
        }

        userDto.setId(UUID.randomUUID());

        this.repository.save(userDto.toEntity());
        return userDto;

    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        this.repository.save(userDto.toEntity());
        return userDto;
    }

    @Override
    public boolean deleteUser(UUID id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public UserDto findUser(UUID id) {

        var userOptional = this.repository.findById(id);

        if(userOptional.isEmpty()){
            return null;
        }else{
            var userEntity = userOptional.get();
            return userEntity.toDto();
        }
    }
}
