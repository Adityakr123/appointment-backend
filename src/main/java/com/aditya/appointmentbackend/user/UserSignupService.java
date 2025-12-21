package com.aditya.appointmentbackend.user;

import com.aditya.appointmentbackend.user.dto.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserRepository userRepository;

    public User signup(UserSignupRequest request) {

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("User already exists with this phone");
        }

        User user = User.builder()
                .phone(request.getPhone())
                .role(request.getRole())
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return userRepository.save(user);
    }
}
