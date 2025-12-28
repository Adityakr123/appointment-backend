package com.aditya.appointmentbackend.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequest {

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phone;

    // Role: mandatory, only "USER" or "BUSINESS"
    @NotBlank(message = "Role is required")
    @Pattern(regexp = "^(USER|BUSINESS|ADMIN)$", message = "Role must be USER or BUSINESS or ADMIN")
    private String role;
}
