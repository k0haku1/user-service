package com.example.user_subscription_service.persistence.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_subscriptions")
public class SubscriptionEntity {

    @Id
    @Column(name = "id", columnDefinition = "UUID")
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "DECIMAL(10, 2)", nullable = false)
    private BigDecimal price;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<UserSubscriptionEntity> subscriptions;
}
