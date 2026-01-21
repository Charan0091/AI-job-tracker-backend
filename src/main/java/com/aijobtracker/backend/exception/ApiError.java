package com.aijobtracker.backend.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Builder
public class ApiError {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
