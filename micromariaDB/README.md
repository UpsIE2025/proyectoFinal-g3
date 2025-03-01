1 Para conectarnos a la base datos postgreSQL ingresamos con los siguientes comandos para verificar que se haya creado la tabla.
 - docker exec -it postgres-db bash
-	psql -U postgres -d auto_db
-	select * from Auto;
2 Para conectarnos a la base datos MariaDB ingresamos con los siguientes comandos para verificar que se haya creado la tabla.
-	docker exec -it mariadb-db bash
-	mysql -u dbuser -p auto_db
-	select * from Auto;

Ver los tópicos Producer
1-	Accede al contenedor de Kafka:
             docker exec -it kafka bash
2-	Ejecuta el siguiente comando para listar los tópicos en Kafka y verificar que el tópico donde el producer envía mensajes exista (en tu caso es dbserver1.public.Auto):
kafka-topics --list --bootstrap-server kafka:9092
3-	Verifica que el producer esté enviando mensajes al tópico correcto utilizando el siguiente comando para describir el tópico:
kafka-console-consumer --bootstrap-server kafka:9092 --topic dbserver1.public.Auto --from-beginning --max-messages 1
Ver los tópicos Consumer
1-	Si tienes un Kafka consumer dentro de un contenedor (como una aplicación Spring Boot o un contenedor Kafka configurado como consumer), puedes utilizar el comando kafka-console-consumer dentro del contenedor Kafka para consumir los mensajes desde un tópico.
a-	Accede al contenedor de Kafka:
docker exec -it kafka bash
b-	Ejecuta el siguiente comando para consumir los mensajes de un tópico:
kafka-console-consumer --bootstrap-server kafka:9092 --topic dbserver1.public.Auto --from-beginning


crear un topico
docker exec -it kafka kafka-topics --create --topic dbhistory.mariadb --bootstrap-server kafka:9092 --partitions 1 --replication-factor 1
