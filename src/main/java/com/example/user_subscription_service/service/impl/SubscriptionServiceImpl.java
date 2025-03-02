package com.example.user_subscription_service.service.impl;

import com.example.user_subscription_service.persistence.models.SubscriptionEntity;
import com.example.user_subscription_service.persistence.models.UserEntity;
import com.example.user_subscription_service.persistence.models.UserSubscriptionEntity;
import com.example.user_subscription_service.persistence.models.UserSubscriptionKey;
import com.example.user_subscription_service.persistence.projection.TopSubscriptionProjection;
import com.example.user_subscription_service.persistence.projection.UserSubscriptionProjection;
import com.example.user_subscription_service.persistence.repository.SubscriptionRepository;
import com.example.user_subscription_service.persistence.repository.UserRepository;
import com.example.user_subscription_service.persistence.repository.UserSubscriptionRepository;
import com.example.user_subscription_service.service.SubscriptionService;
import com.example.user_subscription_service.service.dto.SubscriptionInfo;
import com.example.user_subscription_service.service.dto.TopSubscriptionDto;
import com.example.user_subscription_service.service.dto.UserSubscriptionDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final UserSubscriptionRepository userSubscriptionRepository;

    @Transactional
    public void addSubscription(UUID userId, UUID subscriptionId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        SubscriptionEntity subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found"));

        UserSubscriptionKey key = new UserSubscriptionKey(user.getId(), subscription.getId());

        if (userSubscriptionRepository.existsById(key)) {
            throw new IllegalStateException("User is already subscribed to this service.");
        }

        UserSubscriptionEntity userSubscription = UserSubscriptionEntity.builder()
                .key(key)
                .user(user)
                .subscription(subscription)
                .subscribedAt(LocalDateTime.now())
                .build();

        userSubscriptionRepository.save(userSubscription);
    }

    @Transactional(readOnly = true)
    public UserSubscriptionDto getUserSubscriptions(UUID userId) {
        List<UserSubscriptionProjection> projections = userSubscriptionRepository.findUserSubscriptions(userId);

        List<SubscriptionInfo> subscriptions = projections.stream()
                .map(projection -> new SubscriptionInfo(
                        projection.getSubscriptionId(),
                        projection.getName(),
                        projection.getPrice(),
                        projection.getCreatedAt()))
                .collect(Collectors.toList());

        return new UserSubscriptionDto(projections.get(0).getUserId(), projections.get(0).getUsername(), subscriptions);
    }

    @Transactional
    public void removeSubscription(UUID userId, UUID subscriptionId) {
        UserSubscriptionKey key = new UserSubscriptionKey(userId, subscriptionId);

        if (!userSubscriptionRepository.existsById(key)) {
            throw new EntityNotFoundException("Subscription not found for this user.");
        }

        userSubscriptionRepository.deleteById(key);
    }

    @Transactional(readOnly = true)
    public List<TopSubscriptionDto> getTopSubscriptions() {
        List<TopSubscriptionProjection> projections = subscriptionRepository.findTopSubscriptions();

        return projections.stream()
                .limit(3)
                .map(projection -> new TopSubscriptionDto(
                        projection.getSubscriptionId(),
                        projection.getSubscriptionName(),
                        projection.getUserCount()))
                .collect(Collectors.toList());
    }
}
