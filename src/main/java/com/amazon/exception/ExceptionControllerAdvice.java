package com.amazon.exception;

import com.amazon.dto.UserDto;
import com.amazon.dto.WebApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<WebApiResult<UserDto>> invalidUserExceptionHandler(InvalidUserException exception){
        var res = new WebApiResult<UserDto>();
        res.getAdditionalInformation().add(exception.getMessage());
        return new ResponseEntity<>(res , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<WebApiResult<UserDto>> userNotFoundException(UserNotFoundException exception){
        var res = new WebApiResult<UserDto>();
        res.getAdditionalInformation().add(exception.getMessage());
        return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
    }


}
