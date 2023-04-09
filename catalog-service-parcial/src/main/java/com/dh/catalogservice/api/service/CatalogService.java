package com.dh.catalogservice.api.service;

import com.dh.catalogservice.api.model.Chapter;
import com.dh.catalogservice.api.model.Movie;
import com.dh.catalogservice.api.model.Season;
import com.dh.catalogservice.api.model.Serie;
import com.dh.catalogservice.domain.clients.MovieClient;
import com.dh.catalogservice.domain.clients.SerieClient;
import com.dh.catalogservice.domain.model.CatalogWS;
import com.dh.catalogservice.domain.model.ChapterWS;
import com.dh.catalogservice.domain.model.MovieWS;
import com.dh.catalogservice.domain.model.SeasonWS;
import com.dh.catalogservice.domain.model.SerieWS;
import com.dh.catalogservice.domain.repository.MovieRepository;
import com.dh.catalogservice.domain.repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CatalogService {
    private final MovieClient movieClient;
    private final SerieClient serieClient;

    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;

    public CatalogService(MovieClient movieClient, SerieClient serieClient,
                          MovieRepository movieRepository, SeriesRepository seriesRepository) {
        this.movieClient = movieClient;
        this.serieClient = serieClient;
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
    }

    public CatalogWS getCatalogByGenre(String genre) {

        List<Serie> seriesByGenre = seriesRepository.findByGenre(genre);
        List<Movie> moviesByGenre = movieRepository.findByGenre(genre);

        return CatalogWS.builder().series(seriesByGenre.stream().map(serie -> {
                    SerieWS serieWS = new SerieWS();
                    serieWS.setGenre(serie.getGenre());
                    serieWS.setName(serie.getName());
                    serieWS.setId(serie.getId());
                    serieWS.setSeasons(serie.getSeasons().stream().map(s -> {
                        SeasonWS season = new SeasonWS();
                        season.setId(s.getId());
                        season.setSeasonNumber(s.getSeasonNumber());
                        season.setChapters(s.getChapters().stream().map(c -> {
                            ChapterWS chapter = new ChapterWS();
                            chapter.setId(c.getId());
                            chapter.setNumber(c.getNumber());
                            chapter.setName(c.getName());
                            chapter.setUrlStream(c.getUrlStream());
                            return chapter;
                        }).toList());
                        return season;
                    }).toList());
                    return serieWS;
                }).toList())
                .movies(moviesByGenre.stream().map(m -> {
                    MovieWS movieWS = new MovieWS();
                    movieWS.setGenre(m.getGenre());
                    movieWS.setName(m.getName());
                    movieWS.setUrlStream(m.getUrlStream());
                    movieWS.setId(m.getId());
                    return movieWS;
                }).toList())
                .build();
    }

    public CatalogWS getMoviesByGenre(String genre) {
        return CatalogWS.builder().movies(movieClient.getMoviesByGenre(genre)).genre(genre).build();
    }

    public CatalogWS getSeriesByGenre(String genre) {
        return CatalogWS.builder().series(serieClient.getSeriesByGenre(genre)).genre(genre).build();
    }

    public MovieWS createMovie(MovieWS movimovieWS) {
        Movie movie = new Movie();
        movie.setName(movimovieWS.getName());
        movie.setGenre(movimovieWS.getGenre());
        movie.setUrlStream(movimovieWS.getUrlStream());

        return movieClient.saveMovie(movie);
    }

    public SerieWS createSerie(SerieWS serieWS) {
        Serie serie = new Serie();
        serie.setGenre(serieWS.getGenre());
        serie.setName(serieWS.getName());
        serie.setSeasons(serieWS.getSeasons().stream().map(s -> {
            Season season = new Season();
            season.setId(UUID.randomUUID().toString());
            season.setSeasonNumber(s.getSeasonNumber());
            season.setChapters(s.getChapters().stream().map(c -> {
                Chapter chapter = new Chapter();
                chapter.setId(UUID.randomUUID().toString());
                chapter.setName(c.getName());
                chapter.setUrlStream(c.getUrlStream());
                chapter.setNumber(c.getNumber());
                return chapter;
            }).toList());
            return season;
        }).toList());
        return serieClient.saveSerie(serie);
    }
}
