package palmetto.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import palmetto.model.Order;
import palmetto.model.OrderStatus;

@Service
@Slf4j
public class PalmettoConsumer {

    @Autowired
    PalmettoProducer palmettoProducer;

    @KafkaListener(topics = "order_topic", groupId = "group_id")
    public void consumeMessage(Order order) {
        log.info("PalmettoService: order was received: " + order);
        if (order.getStatus().equals(OrderStatus.NEW)) {
            order.setStatus(OrderStatus.COCKING);
            palmettoProducer.sendMessage(order);
        }


    }
}
