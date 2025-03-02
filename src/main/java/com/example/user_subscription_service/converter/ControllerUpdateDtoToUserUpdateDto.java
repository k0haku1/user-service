package com.example.user_subscription_service.converter;

import com.example.user_subscription_service.controller.dto.ControllerUpdateDto;
import com.example.user_subscription_service.service.dto.UserUpdateDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ControllerUpdateDtoToUserUpdateDto implements Converter <ControllerUpdateDto, UserUpdateDto> {
    @Override
    public UserUpdateDto convert(ControllerUpdateDto source) {
        return UserUpdateDto.builder()
                .username(source.getUsername())
                .name(source.getName())
                .surname(source.getSurname())
                .email(source.getEmail())
                .build();
    }
}
