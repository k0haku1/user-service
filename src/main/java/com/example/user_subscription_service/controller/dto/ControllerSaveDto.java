package com.example.user_subscription_service.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class ControllerSaveDto {

    String username;

    String name;

    String surname;

    String email;

}
