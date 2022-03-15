package com.example.datvexemphimonl.entity.DTO;

import lombok.Data;

@Data
public class MainResponse<T> {
    private int code;
    private String message;
    private String messageCode;
    private T data;

    public MainResponse(int code , String message){
        this.code = code;
        this.message = message;
    }

    public MainResponse(int code , String message, String messageCode){
        this.code = code;
        this.message = message;
        this.messageCode = messageCode;
    }

    public MainResponse(int code , T data, String message){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public MainResponse(T data){
        this.data = data;
    }

    public MainResponse(){
        this.code = 200;
        this.message = "SUCCESS";
    }
}
