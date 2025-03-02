package com.example.user_subscription_service.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {

    private int status;
    private String message;
    private long timestamp;

}
