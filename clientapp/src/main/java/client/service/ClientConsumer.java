package client.service;

import client.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientConsumer {

    @KafkaListener(topics = "notification_topic", groupId = "group_id")
    public void consumeMessage(Order order) {
        log.info("ClientConsumer: order was received: " + order);
    }
}
