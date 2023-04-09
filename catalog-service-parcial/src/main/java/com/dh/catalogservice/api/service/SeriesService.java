package com.dh.catalogservice.api.service;

import com.dh.catalogservice.api.model.Series;
import com.dh.catalogservice.domain.clients.SeriesClient;
import com.dh.catalogservice.domain.model.MovieWS;
import com.dh.catalogservice.domain.model.SerieWS;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class SeriesService {

    private final SeriesClient seriesClient;

    public SeriesService(SeriesClient serieClient) {
        this.seriesClient = serieClient;
    }

    // Si el servicio de series se cae por algun motivo tenemos que poder recuperarnos rapidamente y no demostrar errores
    // por lo tanto teniendo un circuit braker es una forma de no quedarnos sin conexiones (por lo timeout que se generan)
    // y que la aplicacion se caiga de no seguir consumiendo un servicio que esta caido y generando mas trafico al vicio.
    // Hoy se devuelve una lista vacia pero tambien se podria resolver devolviendo algo de una cache en memoria o distribuida
    @CircuitBreaker(name = "series", fallbackMethod = "fallbackgetSeriesByGenre")
    @Retry(name = "series")
    public List<SerieWS> getSeriesByGenre(String genre) {
        return seriesClient.getSeriesByGenre(genre);
    }

    public SerieWS saveSeries(Series series) {
        log.info("saving series {}", series.getName());
        return this.seriesClient.saveSerie(series);
    }

    public List<MovieWS> fallbackgetSeriesByGenre(Throwable t) {
        log.warn("Circuit open, movie service is down", t);
        return Collections.emptyList();
    }
}
