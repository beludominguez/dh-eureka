package com.dh.series.api.service;

import com.dh.series.domain.model.Serie;
import com.dh.series.domain.repository.SeriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SeriesService {

    private final SeriesRepository seriesRepository;

    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public List<Serie> getListByGenre(String genre) {
        return seriesRepository.findByGenre(genre);
    }

    public Serie save(Serie serie) {
        Serie s = seriesRepository.insert(serie);
        List<Serie> ss = seriesRepository.findByGenre(serie.getGenre());
        log.info("all series by genre {} - {}", serie.getGenre(), ss);
        return s;
    }
}
