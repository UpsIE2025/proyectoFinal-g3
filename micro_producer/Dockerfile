# Dockerfile para el microservicio Spring Boot
FROM openjdk:17-jdk-slim AS build
VOLUME /tmp
COPY target/micro_producer-0.0.1.war producer.war
ENTRYPOINT ["java","-jar","/producer.war"]