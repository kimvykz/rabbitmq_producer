package com.aisawan.rmq_producer.component;

import com.aisawan.rmq_producer.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    @Value("${spring.rabbitmq.exchangeName}")
    private String exchangeName;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Message message) {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(exchangeName, message.getRoutingKey(), message.getMessage());
    }
}
