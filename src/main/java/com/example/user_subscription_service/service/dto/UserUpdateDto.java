package com.example.user_subscription_service.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDto {

    private String username;

    private String name;

    private String surname;

    private String email;

}
