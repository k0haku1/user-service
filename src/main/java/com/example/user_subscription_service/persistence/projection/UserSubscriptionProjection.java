package com.example.user_subscription_service.persistence.projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface UserSubscriptionProjection {

    UUID getUserId();
    String getUsername();
    UUID getSubscriptionId();
    String getName();
    BigDecimal getPrice();
    LocalDateTime getCreatedAt();

}
