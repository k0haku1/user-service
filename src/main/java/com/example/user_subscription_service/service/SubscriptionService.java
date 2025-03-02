package com.example.user_subscription_service.service;

import com.example.user_subscription_service.service.dto.TopSubscriptionDto;
import com.example.user_subscription_service.service.dto.UserSubscriptionDto;

import java.util.List;
import java.util.UUID;

public interface SubscriptionService {

    void addSubscription(UUID userId, UUID subscriptionId);

    UserSubscriptionDto  getUserSubscriptions(UUID userId);

    void removeSubscription(UUID userId, UUID subscriptionId);

    List<TopSubscriptionDto> getTopSubscriptions();

}
