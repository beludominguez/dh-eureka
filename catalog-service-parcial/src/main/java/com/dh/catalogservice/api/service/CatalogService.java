package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.clients.MovieClient;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {
    private final MovieClient movieClient;

    public CatalogService(MovieClient movieClient) {
        this.movieClient = movieClient;
    }

    public CatalogWS getMoviesByGenre(String genre) {
        return CatalogWS.builder().movies(movieClient.getMoviesByGenre(genre)).genre(genre).build();
    }
}
