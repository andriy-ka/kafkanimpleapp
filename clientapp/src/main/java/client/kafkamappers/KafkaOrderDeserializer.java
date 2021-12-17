package client.kafkamappers;

import client.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class KafkaOrderDeserializer implements Deserializer<Order> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Order deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data, "UTF-8"), Order.class);
        } catch (Exception e) {
            System.out.println("Unable to deserialize message {}" + data + e);
            return null;
        }
    }

    @Override
    public void close() {
    }
}
