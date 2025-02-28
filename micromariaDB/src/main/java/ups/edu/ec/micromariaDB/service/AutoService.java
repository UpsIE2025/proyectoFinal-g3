package ups.edu.ec.micromariaDB.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ups.edu.ec.micromariaDB.model.Auto;
import ups.edu.ec.micromariaDB.repository.AutoRepository;

@Service
@EnableKafka
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public Auto save(Auto auto) {
        return autoRepository.save(auto);
    }
    //topic
    @KafkaListener(topics = "dbserver1.auto_db.Auto", groupId = "debezium-consumer-group")
    public void consumeMessage(Auto auto) {
        // Convierte el mensaje en un objeto Auto y lo guarda
        save(auto);
    }
}