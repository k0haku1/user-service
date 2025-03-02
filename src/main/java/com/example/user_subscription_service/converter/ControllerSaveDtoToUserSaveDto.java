package com.example.user_subscription_service.converter;

import com.example.user_subscription_service.controller.dto.ControllerSaveDto;
import com.example.user_subscription_service.service.dto.UserSaveDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ControllerSaveDtoToUserSaveDto implements Converter <ControllerSaveDto, UserSaveDto>{
    @Override
    public UserSaveDto convert(ControllerSaveDto source) {
        return UserSaveDto.builder()
                .username(source.getUsername())
                .name(source.getName())
                .surname(source.getSurname())
                .email(source.getEmail())
                .build();
    }
}
