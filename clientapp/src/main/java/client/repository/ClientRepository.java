package client.repository;

import client.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Order, Integer> {
    public Order getOrderById(Integer id);
}
