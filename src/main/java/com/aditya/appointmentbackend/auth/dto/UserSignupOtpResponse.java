package com.aditya.appointmentbackend.auth.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserSignupOtpResponse {
    private String message;
    private LocalDateTime expiresAt;
}


