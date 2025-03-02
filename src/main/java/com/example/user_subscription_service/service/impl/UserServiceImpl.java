package com.example.user_subscription_service.service.impl;

import com.example.user_subscription_service.exception.UserAlreadyExistsException;
import com.example.user_subscription_service.exception.UserNotFoundException;
import com.example.user_subscription_service.persistence.models.UserEntity;
import com.example.user_subscription_service.persistence.repository.UserRepository;
import com.example.user_subscription_service.service.UserService;
import com.example.user_subscription_service.service.dto.UserDto;
import com.example.user_subscription_service.service.dto.UserSaveDto;
import com.example.user_subscription_service.service.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ConversionService conversionService;

    @Transactional
    public UserDto getUserInfoById(UUID id) {
        final UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return conversionService.convert(userEntity, UserDto.class);
    }

    @Transactional
    public void createUser(UserSaveDto userSaveDto) {
        if (userRepository.existsByUsername(userSaveDto.getUsername())) {
            throw new UserAlreadyExistsException(userSaveDto.getUsername());
        }

        UserDto userDto = conversionService.convert(userSaveDto, UserDto.class);
        UserEntity userEntity = conversionService.convert(userDto, UserEntity.class);
        conversionService.convert(userRepository.save(userEntity), UserDto.class);
    }

    @Transactional
    public UserDto updateUserInfo(UserUpdateDto userUpdateDto, UUID id) {

        final UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (userUpdateDto.getUsername() != null
                && !userUpdateDto.getUsername().equals(existingUser.getUsername())
                && userRepository.existsByUsername(userUpdateDto.getUsername())) {
            throw new UserAlreadyExistsException(userUpdateDto.getUsername());
        }if (userUpdateDto.getUsername() != null) {
            existingUser.setUsername(userUpdateDto.getUsername());
        } if (userUpdateDto.getName() != null) {
            existingUser.setName(userUpdateDto.getName());
        } if (userUpdateDto.getSurname() != null) {
            existingUser.setSurname(userUpdateDto.getSurname());
        } if (userUpdateDto.getEmail() != null) {
            existingUser.setEmail(userUpdateDto.getEmail());
        }

        return conversionService.convert(userRepository.save(existingUser), UserDto.class);
    }

    @Transactional
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
