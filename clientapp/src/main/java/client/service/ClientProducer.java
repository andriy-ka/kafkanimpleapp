package client.service;

import client.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientProducer {
    private static final String NOTIFICATION_TOPIC = "notification_topic";
    private static final String ORDER_TOPIC = "order_topic";
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendMessage(Order order) {
        log.info("ClientService: sending the order to notification topic" + order);
        this.kafkaTemplate.send(NOTIFICATION_TOPIC, order);
        log.info("ClientService: sending the order to order topic" + order);
        this.kafkaTemplate.send(ORDER_TOPIC, order);
    }


}
