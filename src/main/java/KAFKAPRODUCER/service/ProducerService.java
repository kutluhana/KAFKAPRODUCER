package KAFKAPRODUCER.service;

import KAFKAPRODUCER.dto.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Object message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Message is sent to kafka: " + message);
    }

    @PostConstruct
    public void sendBefore() {
        Product product = new Product("John Cena");
        send(product);
        System.out.println("Message sent to kafka: " + product);

        Product product2 = new Product("Rey Mysterio");
        send(product2);
        System.out.println("Message sent to kafka: " + product2);

        Product product3 = new Product("The Undertaker");
        send(product3);
        System.out.println("Message sent to kafka: " + product3);

        Product product4 = new Product("The Great Khali");
        send(product4);
        System.out.println("Message sent to kafka: " + product4);

        Product product5 = new Product("Batista");
        send(product5);
        System.out.println("Message sent to kafka: " + product5);
    }
}
