package com.example.user_subscription_service.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class ControllerUpdateDto {

    String username;

    String name;

    String surname;

    String email;


}
