package com.dh.catalogservice.queue;

import com.dh.catalogservice.api.model.Movie;
import com.dh.catalogservice.api.model.Serie;
import com.dh.catalogservice.domain.repository.MovieRepository;
import com.dh.catalogservice.domain.repository.SeriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"movies-queue", "series-queue"})
@Component
@Slf4j
public class Consumers {

    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;

    public Consumers(MovieRepository movieRepository, SeriesRepository seriesRepository) {
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
    }

    @RabbitHandler
    public void handleMessage(Movie movie) {
        log.info("saving movie with id {}", movie.getId());
        movieRepository.save(movie);
    }

    @RabbitHandler
    public void handleMessage(Serie serie) {
        log.info("saving series with id {}", serie.getId());
        seriesRepository.save(serie);
    }
}
