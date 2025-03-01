# **API Gateway con Kong y FastAPI (Modo Declarativo con Docker Compose)** 🚀

## **📌 Descripción**
Este proyecto configura un **API Gateway con Kong** en **modo declarativo**, conectado a un microservicio **FastAPI**. La configuración se maneja mediante un archivo `kong.yml`, lo que permite gestionar servicios y rutas sin necesidad de una base de datos.

---

## **📂 Estructura del Proyecto**
/mi-proyecto-kong
│── /auth0_app_kong/gateway/ # Configuración de Kong
│ ├── kong.yml # Archivo de configuración declarativa
│── /graphql_project/ # Código del microservicio en FastAPI
│── /logs/ # Archivos de logs
│── Dockerfile # Imagen personalizada de FastAPI
│── docker-compose.yml # Configuración para contenedores
│── README.md # Documentación del proyecto


---

## **⚙️ Instalación y Configuración**
### **1️⃣ Requisitos Previos**
Asegúrate de tener instalado:  
- **Docker** y **Docker Compose**  
- **curl** o **Postman** para probar las APIs  

---

### **2️⃣ Configuración Declarativa (`kong.yml`)**
El archivo `kong.yml` define los servicios y rutas:

```yaml
_format_version: "2.1"

services:
  - name: graphql_service
    url: http://graphql_project:8000
    routes:
      - name: graphql_route
        paths:
          - /send-message
          - /test
        strip_path: false

plugins:
  - name: jwt
    service: graphql_service
    config:
      uri_param_names: [jwt]
      key_claim_name: iss
      secret_is_base64: false


# Configuración con docker-compose.yml
###El archivo docker-compose.yml define los servicios de Kong y FastAPI:
version: '3.8'

services:
  kong:
    image: kong:latest
    container_name: kong
    restart: always
    environment:
      KONG_DATABASE: "off"
      KONG_DECLARATIVE_CONFIG: "/etc/kong/kong.yml"
      KONG_PROXY_ACCESS_LOG: "/dev/stdout"
      KONG_ADMIN_ACCESS_LOG: "/dev/stdout"
      KONG_PROXY_ERROR_LOG: "/dev/stderr"
      KONG_ADMIN_ERROR_LOG: "/dev/stderr"
    ports:
      - "8000:8000"  # API Gateway (Kong -> graphql_project)
      - "8443:8443"  # API Gateway HTTPS
      - "8001:8001"  # Administración HTTP de Kong
      - "8444:8444"  # Administración HTTPS de Kong
    volumes:
      - ./auth0_app_kong/gateway/kong.yml:/etc/kong/kong.yml  # Montamos la configuración de Kong
    depends_on:
      - graphql_project
    networks:
      - kong-network

  # Servicio del microservicio en Python (FastAPI)
  graphql_project:
    build:
      context: ./graphql_project  # Ruta donde está el Dockerfile de FastAPI
      dockerfile: Dockerfile
    container_name: graphql_project
    restart: always
    ports:
      - "8002:8000"  # Exponer puerto interno 8000 en 8002 para pruebas directas
    networks:
      - kong-network

networks:
  kong-network:
    driver: bridge


###Para iniciar los servicios con Docker Compose:
docker-compose up -d

# Monitoreo y Logs
###Para revisar los logs de Kong en tiempo real:
docker logs -f kong

