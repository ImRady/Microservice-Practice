package com.bank.account.dto.exception;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private String message;
    private T data;
    private int status;
    private LocalDateTime timestamp;

    public ApiResponse(
            String message, T data, int status, LocalDateTime timestamp) {

        this.message = message;
        this.data = data;
        this.status = status;
        this.timestamp = timestamp;
    }


}
