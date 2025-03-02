package com.example.user_subscription_service.persistence.repository;

import com.example.user_subscription_service.persistence.models.UserSubscriptionEntity;
import com.example.user_subscription_service.persistence.models.UserSubscriptionKey;
import com.example.user_subscription_service.persistence.projection.UserSubscriptionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscriptionEntity, UserSubscriptionKey> {

    @Query("SELECT us.user.id as userId, us.user.username as username, " +
            "us.subscription.id as subscriptionId, us.subscription.name as name, " +
            "us.subscription.price as price, us.subscription.createdAt as createdAt " +
            "FROM UserSubscriptionEntity us " +
            "JOIN us.user u " +
            "JOIN us.subscription s " +
            "WHERE u.id = :userId")
    List<UserSubscriptionProjection> findUserSubscriptions(UUID userId);

}
