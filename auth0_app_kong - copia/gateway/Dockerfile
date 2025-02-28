FROM kong:latest

# Copia el archivo de configuración declarativa a la ubicación correcta
COPY kong.yml /usr/local/kong/declarative/kong.yml

# Configurar Kong en modo declarativo
ENV KONG_DATABASE=off
ENV KONG_DECLARATIVE_CONFIG=/usr/local/kong/declarative/kong.yml

# Comando de inicio correcto para Kong en modo declarativo
CMD ["kong", "docker-start"]
