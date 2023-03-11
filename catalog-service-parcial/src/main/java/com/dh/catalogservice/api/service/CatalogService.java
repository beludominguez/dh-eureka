package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.clients.MovieClient;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {
    private final MovieClient movieClient;

    public CatalogService(MovieClient movieClient) {
        this.movieClient = movieClient;
    }

    public String testClient() {
        return movieClient.test();
    }
}
