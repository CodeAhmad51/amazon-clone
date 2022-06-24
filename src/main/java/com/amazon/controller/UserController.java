package com.amazon.controller;

import com.amazon.dto.UserDto;
import com.amazon.dto.WebApiResult;
import com.amazon.entities.User;
import com.amazon.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<WebApiResult<UserDto>> findById(@PathVariable("id") UUID id){
        var dto = this.service.findUser(id);
        var result =  new WebApiResult<UserDto>();
        result.setResult(dto);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<WebApiResult<List<UserDto>>> findAllUser(){
        var users = this.service.findAllUser();
        var result = new WebApiResult<List<UserDto>>();
        result.setResult(users);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }


}
