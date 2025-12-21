package com.aditya.appointmentbackend.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequest {

    @NotBlank
    private String phone;

    @NotBlank
    private String role; // USER or BUSINESS
}
