# Usamos una imagen base con JDK
FROM openjdk:17-jdk-slim

# Copiamos el archivo JAR del proyecto en el contenedor
COPY target/micromariaDB-0.0.1.jar /app/micromariaDB-0.0.1.jar

# Exponemos el puerto 8080
EXPOSE 8080

# Ejecutamos el archivo JAR de la aplicación Spring Boot
CMD ["java", "-jar", "/app/micromariaDB-0.0.1.jar"]
