
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/user_subscription-service-0.0.1-SNAPSHOT.jar /app/user_service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/user_service.jar"]