package com.dh.catalogservice.domain.clients;

import com.dh.catalogservice.api.model.Serie;
import com.dh.catalogservice.domain.model.SerieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("series-service")
public interface SerieClient {

    @RequestMapping("/series/{genre}")
    List<SerieWS> getSeriesByGenre(@PathVariable String genre);

    @RequestMapping(value = "/series", method = RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    SerieWS saveSerie(Serie serie);
}
