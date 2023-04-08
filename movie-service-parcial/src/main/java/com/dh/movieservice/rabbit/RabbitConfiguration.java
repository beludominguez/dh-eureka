package com.dh.movieservice.rabbit;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${queue.series}")
    private String seriesQueue;

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTamplate = new RabbitTemplate(connectionFactory);
        rabbitTamplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTamplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(this.seriesQueue, true);
    }
}
