package com.dh.series.rabbit;

import com.dh.series.domain.model.Serie;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Value("${queue.series}")
    private String seriesQueue;
    private final RabbitTemplate rabbitTemplate;

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Serie movie) {
        // TODO: add resillience4j for retries with exponential backoff
        rabbitTemplate.convertAndSend(this.seriesQueue, movie);
    }
}
