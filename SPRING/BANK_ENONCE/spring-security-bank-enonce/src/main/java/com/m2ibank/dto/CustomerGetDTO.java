package com.m2ibank.dto;

import lombok.Data;

@Data
public class CustomerGetDTO {
    private Object message;
    public Object data;

    public CustomerGetDTO(Object message) {
        this.message = message;
    }

    public CustomerGetDTO(Object message, Object data) {
        this.message = message;
        this.data = data;
    }
}
