package com.example.user_subscription_service.converter;

import com.example.user_subscription_service.persistence.models.UserEntity;
import com.example.user_subscription_service.service.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDto implements Converter <UserEntity, UserDto> {

    @Override
    public UserDto convert(UserEntity source) {
        return UserDto.builder()
                .id(source.getId())
                .username(source.getUsername())
                .name(source.getName())
                .surname(source.getSurname())
                .createdAt(source.getCreatedAt())
                .email(source.getEmail())
                .build();
    }
}
