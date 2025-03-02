package com.example.user_subscription_service.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSubscriptionDto {
    private UUID userId;
    private String username;
    private List<SubscriptionInfo> subscription;

}
