package dev.devaz.schedule.core.domain.validation;

import java.time.LocalDateTime;

public class ResponseError {
    private final Integer status;
    private final String error;
    private final String message;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public ResponseError(Integer status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
