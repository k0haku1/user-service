package com.example.user_subscription_service.service;

import com.example.user_subscription_service.service.dto.UserDto;
import com.example.user_subscription_service.service.dto.UserSaveDto;
import com.example.user_subscription_service.service.dto.UserUpdateDto;

import java.util.UUID;

public interface UserService {

    UserDto getUserInfoById (UUID id);

    void createUser (UserSaveDto userSaveDto);

    UserDto updateUserInfo (UserUpdateDto userUpdateDto, UUID id);

    void deleteUser (UUID id);
}
