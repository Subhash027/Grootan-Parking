package com.parkingmanagementsystem.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ResponeDetails {

    public ResponeDetails(LocalDateTime timestamp, String message, String description, HttpStatus status) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
        this.status = status;
    }

    private LocalDateTime timestamp;
    private String message;
    private String description;
    HttpStatus status;

    public ResponeDetails() {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
