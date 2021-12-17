package courier.service;

import courier.model.Order;
import courier.model.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CourierConsumer {

    @Autowired
    CourierProducer palmettoProducer;

    @KafkaListener(topics = "notification_topic", groupId = "from_palmetto_to_courier")
    public void consumeMessage(Order order) {
        log.info("CourierService: order was received: " + order);
        if (order.getStatus().equals(OrderStatus.COCKING)) {
            order.setStatus(OrderStatus.DELIVERED);
            palmettoProducer.sendMessage(order);
        }

    }
}
