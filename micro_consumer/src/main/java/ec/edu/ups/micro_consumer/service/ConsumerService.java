package ec.edu.ups.micro_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "telegrafo", groupId = "my-group")
    public void listen(String message) {
        System.out.println("📩 Mensaje recibido en consumidor: " + message);
    }
}