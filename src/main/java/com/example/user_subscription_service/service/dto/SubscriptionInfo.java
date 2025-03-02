package com.example.user_subscription_service.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionInfo {
    private UUID subscriptionId;
    private String name;
    private BigDecimal price;
    private LocalDateTime createdAt;
}
