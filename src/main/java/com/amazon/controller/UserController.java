package com.amazon.controller;

import com.amazon.dto.UserDto;
import com.amazon.dto.WebApiResult;
import com.amazon.entities.User;
import com.amazon.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    IUserService service;

    // ADD USER
    @PostMapping
    public ResponseEntity<WebApiResult<UserDto>> addUser(@RequestBody UserDto userDto){
       var dto =  service.saveUser(userDto);

       var result =  new WebApiResult<UserDto>();
       result.setResult(dto);
       return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


}
