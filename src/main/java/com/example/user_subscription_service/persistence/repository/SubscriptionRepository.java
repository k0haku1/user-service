package com.example.user_subscription_service.persistence.repository;

import com.example.user_subscription_service.persistence.models.SubscriptionEntity;
import com.example.user_subscription_service.persistence.projection.TopSubscriptionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, UUID> {

    @Query("SELECT s.id as subscriptionId, s.name as subscriptionName, COUNT(us) as userCount " +
            "FROM UserSubscriptionEntity us " +
            "JOIN us.subscription s " +
            "GROUP BY s.id " +
            "ORDER BY userCount DESC")
    List<TopSubscriptionProjection> findTopSubscriptions();

}
