package guru.learnjournal.kafka.examples.kafkaproducer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String key, String value) {
        logger.info("Producing Message - Key: %s, Value: %s to Topic: %s", key, value, topic);
        this.kafkaTemplate.send(topic, key, value);
    }

}
