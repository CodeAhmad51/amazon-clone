package com.amazon.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WebApiResult<userDto> {
    public userDto result;
    List<Object> additionalInformation;

    public WebApiResult(){
        this.additionalInformation = new ArrayList<>();
    }


}
