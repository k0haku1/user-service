package com.example.user_subscription_service.converter;

import com.example.user_subscription_service.service.dto.UserDto;
import com.example.user_subscription_service.service.dto.UserSaveDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserSaveDtoToUserDto implements Converter <UserSaveDto, UserDto> {
    @Override
    public UserDto convert(UserSaveDto source) {
        return UserDto.builder()
                .username(source.getUsername())
                .name(source.getName())
                .surname(source.getSurname())
                .email(source.getEmail())
                .build();
    }
}
