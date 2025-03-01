Este documento proporciona instrucciones detalladas para configurar y probar la autenticación con Auth0 utilizando Postman.

1. Configuración en Auth0

1.1 Crear una API en Auth0

Accede a Auth0 Dashboard.

En el menú lateral, ve a Applications > APIs.

Haz clic en Create API.

Completa los siguientes campos:

Name: GS API

Identifier: https://gsapi/  (Este valor se usará en audience)

Signing Algorithm: RS256

Guarda los cambios.

1.2 Configurar una Aplicación en Auth0

Ve a Applications > Applications.

Selecciona tu aplicación o crea una nueva.

Ve a la pestaña Advanced Settings > Grant Types.

Asegúrate de que la opción Client Credentials esté habilitada.

Guarda los cambios.

1.3 Habilitar Acceso desde la Aplicación

Ve a Applications > APIs.

Selecciona la API que creaste (GS API).

En la pestaña Machine to Machine Applications, encuentra tu aplicación y actívala.

Asigna los permisos necesarios.

Guarda los cambios.

2. Prueba de Autenticación con Postman

2.1 Configurar la Petición en Postman

Abre Postman y crea una nueva petición POST a:

https://peterpoint.us.auth0.com/oauth/token

Ve a la pestaña Headers y agrega:

Content-Type: application/json

Ve a la pestaña Body, selecciona raw y el formato JSON.

Ingresa el siguiente JSON:

{
  "client_id": "apW76f49Y5MvyTcLq0q0KBDd0gsV3wVq",
  "client_secret": "BM9syhW4ywXt9uHDRbCjAoUu33gKLkxba_mIJ5wnI3w7sPLgDUXu5_bU8yH33pQW",
  "audience": "https://gsapi/",
  "grant_type": "client_credentials"
}

Presiona Send.

2.2 Respuesta Esperada

Si todo está configurado correctamente, recibirás una respuesta similar a esta:

{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "token_type": "Bearer",
  "expires_in": 86400
}

3. Uso del Token en Otras Peticiones

Para realizar peticiones a la API protegida, agrega el token al encabezado Authorization:

Header: Authorization: Bearer TU_ACCESS_TOKEN

Ejemplo de petición GET:

GET https://tu-api.com/endpoint
Headers:
Authorization: Bearer eyJhbGciOiJIUzI1Ni...

4. Solución de Problemas

unauthorized_client: Asegúrate de que la aplicación tenga habilitado Client Credentials y esté autorizada para la API.

access_denied: Verifica que el audience sea correcto y coincida con el Identifier de la API en Auth0.

invalid_grant: Revisa que el client_id y client_secret sean los correctos.