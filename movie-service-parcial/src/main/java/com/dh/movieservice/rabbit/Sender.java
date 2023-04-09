package com.dh.movieservice.rabbit;

import com.dh.movieservice.domain.model.Movie;
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

    public void sendMessage(Movie movie) {
        // TODO: add resillience4j for retries with exponential backoff
        rabbitTemplate.convertAndSend(this.seriesQueue, movie);
    }
}
