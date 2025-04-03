package com.aisawan.rmq_producer.controller;

import com.aisawan.rmq_producer.component.RabbitMQProducer;
import com.aisawan.rmq_producer.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("producer")
public class ProducerController {

    private final RabbitMQProducer producer;

    @PostMapping()
    public String sendMessage(@RequestBody Message message) {
        producer.send(message);
        return String.format("Received message: routing_key '%s', message - %s", message.getRoutingKey(), message.getMessage());
    }

}
