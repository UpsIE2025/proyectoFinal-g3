# Dockerfile para el microservicio Spring Boot
FROM openjdk:17-jdk-slim AS build
VOLUME /tmp
COPY target/micro_consumer-0.0.1.war consumer.war
ENTRYPOINT ["java","-jar","/consumer.war"]