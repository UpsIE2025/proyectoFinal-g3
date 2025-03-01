# Etapa de compilación
FROM maven:3.8.7-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa final
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/micro_producer-0.0.1.war producer.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/producer.war"]
