package com.dh.catalogservice.domain.clients;

import com.dh.catalogservice.api.model.Movie;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("movie-service")
public interface MovieClient {

    @RequestMapping("/movies/{genre}")
    List<MovieWS> getMoviesByGenre(@PathVariable String genre);

    @RequestMapping(value = "/movies", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    MovieWS saveMovie(Movie movie);
}
