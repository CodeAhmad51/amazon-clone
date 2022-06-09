package com.amazon.controller;

import com.amazon.dto.UserDto;
import com.amazon.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    IUserService service;

    @PostMapping("/user")
    public UserDto addUser(@RequestBody UserDto userDto){
       return  service.saveUser(userDto);
    }

    @GetMapping("/hello")
    String hello(){
        return "Hello world";
    }

}
