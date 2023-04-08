package com.dh.catalogservice.api.service;

import com.dh.catalogservice.api.model.Chapter;
import com.dh.catalogservice.api.model.Movie;
import com.dh.catalogservice.api.model.Season;
import com.dh.catalogservice.api.model.Serie;
import com.dh.catalogservice.domain.clients.MovieClient;
import com.dh.catalogservice.domain.clients.SerieClient;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {
    private final MovieClient movieClient;
    private final SerieClient serieClient;

    public CatalogService(MovieClient movieClient, SerieClient serieClient) {
        this.movieClient = movieClient;
        this.serieClient = serieClient;
    }

    public CatalogWS getMoviesByGenre(String genre) {
        return CatalogWS.builder().movies(movieClient.getMoviesByGenre(genre)).genre(genre).build();
    }

    public CatalogWS createMovie(MovieWS movimovieWS) {
        Movie movie = new Movie();
        movie.setName(movimovieWS.getName());
        movie.setGenre(movimovieWS.getGenre());
        movie.setUrlStream(movimovieWS.getUrlStream());

        return CatalogWS.builder().movies(Lists.newArrayList(movieClient.saveMovie(movie))).build();
    }

    public CatalogWS createSerie(SerieWS serieWS) {
        Serie serie = new Serie();
        serie.setGenre(serieWS.getGenre());
        serie.setName(serieWS.getName());
        serie.setSeasons(serieWS.getSeasons().stream().map(s -> {
            Season season = new Season();
            season.setSeasonNumber(s.getSeasonNumber());
            season.setChapters(s.getChapters().stream().map(c -> {
                Chapter chapter = new Chapter();
                chapter.setName(c.getName());
                chapter.setUrlStream(c.getUrlStream());
                chapter.setNumber(c.getNumber());
                return chapter;
            }).toList());
            return season;
        }).toList());
        return CatalogWS.builder().movies(Lists.newArrayList(serieClient.saveSerie(serie))).build();
    }
}
