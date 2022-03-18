package com.example.datvexemphimonl.entity.DTO.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiException  extends RuntimeException{
    private int code;
    private HttpStatus httpStatus;
    private String messageCode;

    public ApiException(ERROR exception) {
        super(exception.getMessage());
        this.code = exception.getCode();

        this.httpStatus = HttpStatus.OK;
    }

    public ApiException(ERROR exception, HttpStatus status) {
        super();
        this.code = exception.getCode();

        this.httpStatus = status;
    }

    public ApiException(int code, String errorMsg) {
        super(errorMsg);
        this.code = code;
        this.httpStatus = HttpStatus.OK;
    }

    public ApiException(ERROR exception, String errorMsg) {
        super(errorMsg);
        this.code = exception.getCode();

        this.httpStatus = HttpStatus.valueOf(exception.getCode());
    }

    public ApiException(ERROR exception, String errorMsg, String messageCode) {
        super(errorMsg);
        this.code = exception.getCode();
        this.messageCode = messageCode;
        this.httpStatus = HttpStatus.valueOf(exception.getCode());
    }

    public ApiException(int code, String errorMsg, HttpStatus httpStatus) {
        super(errorMsg);
        this.code = code;

        this.httpStatus = httpStatus;
    }
}
