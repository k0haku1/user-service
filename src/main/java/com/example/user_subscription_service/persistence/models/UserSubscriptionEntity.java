package com.example.user_subscription_service.persistence.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_user_subscriptions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSubscriptionEntity {

    @EmbeddedId
    private UserSubscriptionKey key;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user")
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("subscription")
    @JoinColumn(name = "subscription_id")
    private SubscriptionEntity subscription;

    @Column(nullable = false)
    private LocalDateTime subscribedAt = LocalDateTime.now();
}
