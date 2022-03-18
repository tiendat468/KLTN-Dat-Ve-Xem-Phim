package com.example.datvexemphimonl.entity.DTO.exception;

public enum ERROR {
    INVALID_REQUEST(400, "invalid request"),
    INVALID_PARAM(400, "invalid param"),
    UNAUTHORIZED(401, "unauthorized"),
    UNAVAILABLE(503, "service unavailable"),
    ;
    private int code;
    private String message;

    ERROR(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
