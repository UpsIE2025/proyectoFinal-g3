package ups.edu.ec.micromariaDB.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DebeziumConsumerService {

    // Este método se invoca cuando Debezium envía un mensaje a Kafka.
    @KafkaListener(topics = "dbserver1.exampledb.public.my_entity", groupId = "debezium-consumer-group")
    @Transactional
    public void consume(String message) {
        // Aquí procesamos el mensaje recibido y replicamos los datos a MariaDB
        System.out.println("Mensaje recibido de Kafka: " + message);

        // Aquí puedes agregar la lógica para replicar el mensaje a tu base de datos MariaDB.
        // Podrías usar un repositorio JPA o JDBC para insertar/actualizar registros en tu base de datos.
    }
}
