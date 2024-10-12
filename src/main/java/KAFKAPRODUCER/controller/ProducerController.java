package KAFKAPRODUCER.controller;

import KAFKAPRODUCER.dto.Product;
import KAFKAPRODUCER.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping
    public String healthCheck(@RequestBody String message) {
        producerService.send(message);
        return "Message is sent successfully";
    }

    @PostMapping
    public String sendProductMessage(@RequestBody Product product) {
        producerService.send(product);
        return "Message is sent successfully";
    }
}
