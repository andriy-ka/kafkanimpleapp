package palmetto.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import palmetto.model.Order;

@Service
@Slf4j
public class PalmettoProducer {
    private static final String NOTIFICATION_TOPIC = "notification_topic";
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendMessage(Order order) {
        log.info("PalmettoService: sending order to notification topic " + order);
        this.kafkaTemplate.send(NOTIFICATION_TOPIC, order);
    }
}
