package client.controller;

import client.entity.Order;
import client.entity.OrderStatus;
import client.service.ClientProducer;
import client.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final OrderService orderService;
    private final ClientProducer producer;


    public ClientController(OrderService orderService, ClientProducer producer) {
        this.orderService = orderService;
        this.producer = producer;
    }

    @PostMapping("/order")
    public void save(@RequestBody Order order) {
        if (order != null) {
            order.setStatus(OrderStatus.NEW);
            producer.sendMessage(order);
            orderService.save(order);
        }
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }
}
