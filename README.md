# Proyecto gRPC

Este proyecto implementa un servicio utilizando **gRPC** en **Java** con **Maven**.

## Estructura del Proyecto

```
grpc/
│── src/                 # Código fuente
│── target/              # Archivos generados
│── .mvn/                # Configuración de Maven
│── .idea/               # Configuración de IntelliJ IDEA
│── pom.xml              # Archivo de configuración de Maven
│── mvnw, mvnw.cmd       # Wrappers de Maven
│── docker-compose.yml   # Configuración para Docker
│── .gitignore           # Archivos ignorados en Git
│── HELP.md              # Documentación adicional
```

## Requisitos Previos

- **Java 11+**
- **Maven**
- **Docker** (opcional, si se usa `docker-compose`)

## Instalación y Ejecución

### Compilar el proyecto
```sh
./mvnw clean package
```

### Ejecutar el servicio
```sh
./mvnw spring-boot:run
```

### Usar Docker (opcional)
```sh
docker-compose up --build
```

## Prueba de los servicios gRPC

Puedes utilizar **grpcurl** para probar los servicios gRPC.

### Crear un Auto
```sh
grpcurl -plaintext -d '{
  "marca": "Toyota",
  "modelo": "Corolla",
  "anio": 2022
}' localhost:9090 com.grupo3.grpc.AutoService/CreateAuto
```

### Listar Autos
```sh
grpcurl -plaintext -d '{}' localhost:9090 com.grupo3.grpc.AutoService/ListAutos
```

## Licencia

Este proyecto está bajo la licencia MIT.
