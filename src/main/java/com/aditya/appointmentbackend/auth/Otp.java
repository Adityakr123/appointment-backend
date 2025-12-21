package com.aditya.appointmentbackend.auth;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
@Entity
@Table(name = "otp_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(name = "otp_hash",nullable = false)
    private String otpHash ;

    @Column(name = "attempt_count", nullable =false)
    private Integer attemptCount = 0 ;

    @Column(name = "max_attempts", nullable = false)
    private Integer maxAttempts = 5 ;

    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "expires_at" ,nullable = false)
    private LocalDateTime expiresAt;
}
