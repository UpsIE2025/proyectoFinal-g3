# Etapa 1: Construcción del WAR
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Configurar UTF-8 para evitar problemas de codificación
ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

# Copiar archivos y compilar el WAR
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con OpenJDK
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar el WAR desde la etapa de construcción
COPY --from=build /app/target/micro_producer-0.0.1.war producer.war

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/producer.war"]
