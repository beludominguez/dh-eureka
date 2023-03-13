package com.dh.catalogservice.domain.clients;

import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("movie-service")
public interface MovieClient {

    @RequestMapping("/movies/{genre}")
    List<MovieWS> getMoviesByGenre(@PathVariable String genre);
}
