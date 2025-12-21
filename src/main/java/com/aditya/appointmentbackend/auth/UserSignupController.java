package com.aditya.appointmentbackend.auth;

import com.aditya.appointmentbackend.auth.dto.UserSignupRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserSignupController {

    private final UserSignupService signupService;

    @PostMapping("/signupOtpRequest")
    public ResponseEntity<?> signupOtpRequest(
            @Valid @RequestBody UserSignupRequest request
    ) {
        return ResponseEntity.ok(signupService.signupOtpRequest(request));
    }
}
