package com.example.user_subscription_service.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class UserDto {
    UUID id;
    String username;
    String name;
    String surname;
    String email;
    LocalDateTime createdAt;
}
