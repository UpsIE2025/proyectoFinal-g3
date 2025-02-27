package ec.edu.ups.rest.MicroRest_Producer.controller;

import ec.edu.ups.rest.MicroRest_Producer.KafkaProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        logger.info("📩 Mensaje recibido para enviar a Kafka: {}", message);
        kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME, message);
        return ResponseEntity.ok("Mensaje enviado al topic '" + KafkaProducerConfig.TOPIC_NAME + "': " + message);
    }
}
