package com.dh.catalogservice.domain.clients;

import com.dh.catalogservice.api.model.Serie;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("series-service")
public interface SerieClient {

    @RequestMapping("/series/{genre}")
    List<MovieWS> getSeriesByGenre(@PathVariable String genre);

    @RequestMapping("/series")
    MovieWS saveSerie(@RequestBody Serie serie);
}
