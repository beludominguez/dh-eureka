package com.dh.series.series.api.controller;

import com.dh.series.series.api.service.SeriesService;
import com.dh.series.series.domain.model.Serie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {
    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(seriesService.getListByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Serie> saveMovie(@RequestBody Serie serie) {
        return ResponseEntity.ok().body(seriesService.save(serie));
    }
}
