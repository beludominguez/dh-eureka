package com.dh.series.api.service;

import com.dh.series.domain.model.Serie;
import com.dh.series.domain.repository.SeriesRepository;
import com.dh.series.rabbit.Sender;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SeriesService {

    private final SeriesRepository seriesRepository;
    private final Sender sender;

    private final RetryRegistry retryRegistry;

    public SeriesService(SeriesRepository seriesRepository, Sender sender, RetryRegistry retryRegistry) {
        this.seriesRepository = seriesRepository;
        this.sender = sender;
        this.retryRegistry = retryRegistry;
    }

    public List<Serie> getListByGenre(String genre) {
        return seriesRepository.findByGenre(genre);
    }

    public Serie save(Serie serie) {
        try {
            Serie s = seriesRepository.insert(serie);

            log.info("Series created with id {}", s.getId());
            Retry retry = this.retryRegistry.retry("movies-message");
            retry.executeRunnable(() -> this.sender.sendMessage(s));
            return s;
        } catch (Exception e) {
            log.error("series cannot be saved", e);
            throw e;
        }
    }
}
