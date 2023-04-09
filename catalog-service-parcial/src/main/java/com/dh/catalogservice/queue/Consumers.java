package com.dh.catalogservice.queue;

import com.dh.catalogservice.api.model.Movie;
import com.dh.catalogservice.api.model.Series;
import com.dh.catalogservice.domain.repository.MovieRepository;
import com.dh.catalogservice.domain.repository.SeriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumers {

    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;

    public Consumers(MovieRepository movieRepository, SeriesRepository seriesRepository) {
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
    }

    @RabbitListener(queues = {"movies-queue"})
    public void handleMessage(Movie movie) {
        log.info("saving movie in catalog with id {}", movie.getId());
        movieRepository.save(movie);
    }

    @RabbitListener(queues = {"series-queue"})
    public void handleMessage(Series series) {
        log.info("saving series in catalog  with id {}", series.getId());
        seriesRepository.save(series);
    }
}
