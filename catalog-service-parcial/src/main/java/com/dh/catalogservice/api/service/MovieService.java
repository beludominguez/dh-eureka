package com.dh.catalogservice.api.service;

import com.dh.catalogservice.api.model.Movie;
import com.dh.catalogservice.domain.clients.MovieClient;
import com.dh.catalogservice.domain.model.MovieWS;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class MovieService {

    private final MovieClient movieClient;

    public MovieService(MovieClient movieClient) {
        this.movieClient = movieClient;
    }

    // Si el servicio de series se cae por algun motivo tenemos que poder recuperarnos rapidamente y no demostrar errores
    // por lo tanto teniendo un circuit braker es una forma de no quedarnos sin conexiones (por lo timeout que se generan)
    // y que la aplicacion se caiga de no seguir consumiendo un servicio que esta caido y generando mas trafico al vicio.
    // Hoy se devuelve una lista vacia pero tambien se podria resolver devolviendo algo de una cache en memoria o distribuida
    @CircuitBreaker(name = "movies", fallbackMethod = "fallbackGetMoviesByGenre")
    @Retry(name = "movies")
    public List<MovieWS> getMoviesByGenre(String genre) {
        return movieClient.getMoviesByGenre(genre);
    }

    public MovieWS saveMovie(Movie movie) {
        log.info("saving movie {}", movie.getName());
        return this.movieClient.saveMovie(movie);
    }

    public List<MovieWS> fallbackGetMoviesByGenre(Throwable t) {
        log.warn("Circuit open, movie service is down", t);
        return Collections.emptyList();
    }
}
