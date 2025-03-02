package com.example.user_subscription_service.controller;

import com.example.user_subscription_service.service.SubscriptionService;
import com.example.user_subscription_service.service.dto.TopSubscriptionDto;
import com.example.user_subscription_service.service.dto.UserSubscriptionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/{userId}/{subscriptionId}")
    public ResponseEntity<Void> addSubscription(@PathVariable UUID userId, @PathVariable UUID subscriptionId) {
        subscriptionService.addSubscription(userId, subscriptionId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserSubscriptionDto> getUserSubscriptions(@PathVariable UUID userId) {
        UserSubscriptionDto subscriptions = subscriptionService.getUserSubscriptions(userId);
        return ResponseEntity.ok(subscriptions);
    }

    @DeleteMapping("/{userId}/{subscriptionId}")
    public ResponseEntity<Void> removeSubscription(@PathVariable UUID userId, @PathVariable UUID subscriptionId) {
        subscriptionService.removeSubscription(userId, subscriptionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<TopSubscriptionDto>> getTopSubscriptions() {
        List<TopSubscriptionDto> topSubscriptions = subscriptionService.getTopSubscriptions();
        return ResponseEntity.ok(topSubscriptions);
    }
}
