package courier.kafkamapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import courier.model.Order;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class KafkaOrderSerializer implements Serializer<Order> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Order data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            System.out.println("Unable to serialize object {}" + data + e);
            return null;
        }
    }

    @Override
    public void close() {
    }
}
