package com.aditya.appointmentbackend.auth;

import com.aditya.appointmentbackend.auth.dto.UserSignupOtpResponse;
import com.aditya.appointmentbackend.auth.dto.UserSignupRequest;
import com.aditya.appointmentbackend.utilities.OtpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserRepository userRepository;
    private final OtpRepository otpRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserSignupOtpResponse signupOtpRequest(UserSignupRequest request) {

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("User already exists with this phone");
        }
        String plainOtp = OtpUtil.generateOtp();

        String hashedOtp = passwordEncoder.encode(plainOtp);

        Otp otp = Otp.builder()
                .phone(request.getPhone())
                .otpHash(hashedOtp)
                .attemptCount(0)
                .maxAttempts(5)
                .isUsed(false)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(2)) // OTP valid for 2 min
                .build();

        otpRepository.save(otp);
        return new UserSignupOtpResponse(
                "OTP sent successfully",
                otp.getExpiresAt()
        );


//        User user = User.builder()
//                .phone(request.getPhone())
//                .role(request.getRole())
//                .isActive(true)
//                .createdAt(LocalDateTime.now())
//                .updatedAt(LocalDateTime.now())
//                .build();
//
//        return userRepository.save(user);
    }
}
