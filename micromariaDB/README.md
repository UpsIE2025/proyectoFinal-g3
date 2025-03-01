# Miroservicio CDC

Este miroservicio escucha modificaciones que se realizan en la base de postgreSQL los cuales seran replicados hacia la base Maria DB

## Requisitos Previos

- **Java 11+**
- **Maven**
- **Docker**
- **Zookeeper**
- **kafka**
- **Debezium**

## Instalacion y Configuracion

## Compilar Microservicio
```sh
mvn clean install 
```

## Prerequisitos para la creaccion y permisos necesitos base datos
```
micromariaDB/
│── init-scripts/
│──── mariadb/            
│────── init_mariadb.sql/
│──── postgresql/            
│────── init_postgresql.sql/    
```

### Usar Docker (opcional)
```sh
docker-compose up --build
```

## Para conectarnos a la base datos postgreSQL ingresamos con los siguientes comandos para verificar que se haya creado la tabla.
```sh
docker exec -it postgres-db bash
psql -U postgres -d auto_db
select * from Auto;
```

## Para conectarnos a la base datos MariaDB ingresamos con los siguientes comandos para verificar que se haya creado la tabla.
```sh
docker exec -it mariadb-db bash
mysql -u dbuser -p auto_db
select * from Auto;
```

## Ver los tópicos Producer

## Accede al contenedor de Kafka:
```sh
docker exec -it kafka bash
```
## Ejecuta el siguiente comando para listar los tópicos en Kafka y verificar que el tópico donde el producer envía mensajes exista (dbserver1.public.Auto)
```sh
kafka-topics --list --bootstrap-server kafka:9092
```

## Verifica que el producer esté enviando mensajes al tópico correcto utilizando el siguiente comando para describir el tópico:
```sh
kafka-console-consumer --bootstrap-server kafka:9092 --topic dbserver1.public.Auto --from-beginning --max-messages 1
```

## Ver los tópicos Consumer

## Para verificar un Kafka consumer dentro de un contenedor (como una aplicación Spring Boot o un contenedor Kafka configurado como consumer), se puede utilizar el comando kafka-console-consumer dentro del contenedor Kafka para consumir los mensajes desde un tópico.

##Accede al contenedor de Kafka:
```sh
docker exec -it kafka bash
```

##Ejecutar el siguiente comando para consumir los mensajes de un tópico:
```sh
kafka-console-consumer --bootstrap-server kafka:9092 --topic dbserver1.public.Auto --from-beginning
```

##Ver topicos generados
```sh
kafka-topics.sh --bootstrap-server localhost:9092 --list
```

## crear un topico
```sh
docker exec -it kafka kafka-topics --create --topic dbhistory.mariadb --bootstrap-server kafka:9092 --partitions 1 --replication-factor 1
```
## Licencia

Este proyecto está bajo la licencia MIT.
