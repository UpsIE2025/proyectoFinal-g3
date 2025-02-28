# Etapa 1: Construcción de la aplicación
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final para la ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/grpc-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
