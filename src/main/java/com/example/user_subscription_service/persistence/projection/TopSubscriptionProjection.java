package com.example.user_subscription_service.persistence.projection;

import java.util.UUID;

public interface TopSubscriptionProjection {

    UUID getSubscriptionId();
    String getSubscriptionName();
    Long getUserCount();

}
