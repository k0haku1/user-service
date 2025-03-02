package com.example.user_subscription_service.converter;

import com.example.user_subscription_service.persistence.models.UserEntity;
import com.example.user_subscription_service.service.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UserDtoToUserEntity implements Converter <UserDto, UserEntity> {
    @Override
    public UserEntity convert(UserDto source) {
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .username(source.getUsername())
                .name(source.getName())
                .surname(source.getSurname())
                .email(source.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
