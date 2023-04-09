package com.dh.series.api.service;

import com.dh.series.domain.model.Serie;
import com.dh.series.domain.repository.SeriesRepository;
import com.dh.series.rabbit.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SeriesService {

    private final SeriesRepository seriesRepository;
    private final Sender sender;

    public SeriesService(SeriesRepository seriesRepository, Sender sender) {
        this.seriesRepository = seriesRepository;
        this.sender = sender;
    }

    public List<Serie> getListByGenre(String genre) {
        return seriesRepository.findByGenre(genre);
    }

    public Serie save(Serie serie) {
        Serie s = seriesRepository.insert(serie);

        log.info("Series created with id {}", s.getId());
        sender.sendMessage(s);
        return s;
    }
}
