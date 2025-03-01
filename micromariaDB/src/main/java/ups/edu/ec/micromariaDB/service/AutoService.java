package ups.edu.ec.micromariaDB.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ups.edu.ec.micromariaDB.model.Auto;
import ups.edu.ec.micromariaDB.repository.AutoRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    // Para manejar los mensajes de Kafka (mantener este método para Kafka)
    @KafkaListener(topics = "dbserver1.public.auto", groupId = "debezium-consumer-group")
    public void consumeKafka(String message) {
        try {
            // Convertir el mensaje JSON de Kafka en un objeto Auto
            ObjectMapper objectMapper = new ObjectMapper();
            Auto auto = objectMapper.readValue(message, Auto.class);

            // Guardar el auto en MariaDB
            autoRepository.save(auto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para guardar directamente a través del POST (HTTP)
    public Auto save(Auto auto) {
        return autoRepository.save(auto);
    }
}
