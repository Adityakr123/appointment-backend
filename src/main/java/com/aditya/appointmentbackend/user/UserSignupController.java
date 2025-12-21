package com.aditya.appointmentbackend.user;

import com.aditya.appointmentbackend.user.dto.UserSignupRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserSignupController {

    private final UserSignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(
            @Valid @RequestBody UserSignupRequest request
    ) {
        return ResponseEntity.ok(signupService.signup(request));
    }
}
