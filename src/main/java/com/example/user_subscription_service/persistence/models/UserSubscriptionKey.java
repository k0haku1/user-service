package com.example.user_subscription_service.persistence.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserSubscriptionKey implements Serializable {
    @JoinColumn(name = "user_id")
    private UUID user;
    @JoinColumn(name = "subscription_id")
    private UUID subscription;
}
