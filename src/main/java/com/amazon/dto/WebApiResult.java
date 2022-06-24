package com.amazon.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WebApiResult<TResult> {
    public TResult result;
    List<Object> additionalInformation;

    public WebApiResult(){

        this.additionalInformation = new ArrayList<>();
    }


}
