package com.example.user_subscription_service.controller;

import com.example.user_subscription_service.controller.dto.ControllerSaveDto;
import com.example.user_subscription_service.controller.dto.ControllerUpdateDto;
import com.example.user_subscription_service.service.UserService;
import com.example.user_subscription_service.service.dto.UserDto;
import com.example.user_subscription_service.service.dto.UserSaveDto;
import com.example.user_subscription_service.service.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ConversionService conversionService;


    @PostMapping("create")
    public ResponseEntity<UserDto> createUser(
            @RequestBody ControllerSaveDto userSaveDto) {
        UserSaveDto convertedDto = conversionService.convert(userSaveDto, UserSaveDto.class);
        userService.createUser(convertedDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserInfo(
            @PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserInfoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @RequestBody ControllerUpdateDto userUpdateDto) {
        return ResponseEntity.ok(userService.updateUserInfo(conversionService.convert(userUpdateDto, UserUpdateDto.class), id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

}
