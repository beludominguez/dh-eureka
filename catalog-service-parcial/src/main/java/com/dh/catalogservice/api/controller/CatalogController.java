package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.CatalogWS;
import com.dh.catalogservice.domain.model.MovieWS;
import com.dh.catalogservice.domain.model.SerieWS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/{genre}")
    ResponseEntity<CatalogWS> getCatalogByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(catalogService.getCatalogByGenre(genre));
    }

    @GetMapping("/movies/{genre}")
    ResponseEntity<CatalogWS> getMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(catalogService.getMoviesByGenre(genre));
    }

    @GetMapping("/series/{genre}")
    ResponseEntity<CatalogWS> getSeriesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(catalogService.getSeriesByGenre(genre));
    }

    @PostMapping("/movies")
    ResponseEntity<MovieWS> saveMovie(@RequestBody MovieWS moviesWS) {
        return ResponseEntity.ok().body(catalogService.createMovie(moviesWS));
    }

    @PostMapping("/series")
    ResponseEntity<SerieWS> saveMovie(@RequestBody SerieWS serieWS) {
        return ResponseEntity.ok().body(catalogService.createSerie(serieWS));
    }
}
