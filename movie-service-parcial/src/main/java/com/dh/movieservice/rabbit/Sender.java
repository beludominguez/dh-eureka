package com.dh.movieservice.rabbit;

import com.dh.movieservice.domain.model.Movie;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private final RabbitTemplate rabbitTemplate;

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Movie movie) {
        // TODO: add resillience4j for retries with exponential backoff
        rabbitTemplate.convertAndSend(movie);
    }
}
