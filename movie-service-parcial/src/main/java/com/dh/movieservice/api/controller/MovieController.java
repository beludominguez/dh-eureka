package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MoviesService;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MoviesService moviesService;

    public MovieController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(moviesService.getListByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(moviesService.save(movie));
    }
}
