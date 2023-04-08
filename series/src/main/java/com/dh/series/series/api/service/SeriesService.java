package com.dh.series.series.api.service;

import com.dh.series.series.domain.model.Serie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesService {

    public List<Serie> getListByGenre(String genre) {
        return new ArrayList<>();
    }

    public Serie save(Serie serie) {
        return new Serie();
    }
}
