package com.entity;

import lombok.Data;

@Data
public class ApiResponse {


    private Integer code;
    private String type;
    private String message;


    @Override
    public String toString() {
        return "ApiResponse{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
