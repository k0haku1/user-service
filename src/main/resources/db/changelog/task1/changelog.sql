CREATE TABLE t_users (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE t_subscriptions (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE t_user_subscriptions (
    user_id UUID NOT NULL,
    subscription_id UUID NOT NULL ,
    subscribed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, subscription_id ),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES t_users(id),
    CONSTRAINT fk_subscriptions FOREIGN KEY (subscription_id) REFERENCES t_subscriptions(id)
);