package com.example.user_subscription_service.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopSubscriptionDto {
    private UUID subscriptionId;
    private String subscriptionName;
    private long userCount;
}
