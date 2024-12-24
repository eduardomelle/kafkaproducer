package guru.learnjournal.kafka.examples.kafkaproducer.services;

import guru.learnjournal.kafka.examples.kafkaproducer.model.IncomingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaMessageController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/post")
    public String sendMessageToKafka(@RequestBody IncomingMessage message) {
        this.kafkaProducerService.sendMessage(message.getTopic(), message.getKey(), message.getValue());
        return String.format("Success - Message for key: %s is sent to Kafka topic: %s",
                message.getKey(), message.getTopic());
    }

}
