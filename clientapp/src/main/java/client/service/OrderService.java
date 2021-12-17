package client.service;

import client.entity.Order;
import client.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ClientRepository clientRepository;

    public OrderService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void save(Order order) {
        clientRepository.save(order);
    }

    public Order getOrder(Integer id) {
        return clientRepository.getOrderById(id);
    }
}
