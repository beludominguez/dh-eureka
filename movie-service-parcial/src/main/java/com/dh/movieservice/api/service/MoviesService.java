package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import com.dh.movieservice.rabbit.Sender;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MoviesService {
    private final MovieRepository movieRepository;
    private final Sender sender;
    private final RetryRegistry retryRegistry;

    public MoviesService(MovieRepository movieRepository, Sender sender, RetryRegistry retryRegistry) {
        this.movieRepository = movieRepository;
        this.sender = sender;
        this.retryRegistry = retryRegistry;
    }

    public List<Movie> getListByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    public Movie save(Movie movie) {
        try {
            Movie m = movieRepository.save(movie);
            Retry retry = this.retryRegistry.retry("movies-message");
            retry.executeRunnable(() -> this.sender.sendMessage(m));
            log.info("Movie created with id {}", m.getId());
            return m;
        } catch (Exception e) {
            log.error("movie cannot be saved", e);
            throw e;
        }
    }
}
