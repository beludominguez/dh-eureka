package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import com.dh.movieservice.rabbit.Sender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final Sender sender;
    private RabbitTemplate rabbitTemplate;

    public MovieServiceImpl(MovieRepository movieRepository, Sender sender) {
        this.movieRepository = movieRepository;
        this.sender = sender;
    }

    @Override
    public List<Movie> getListByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    @Override
    public Movie save(Movie movie) {
        // TODO: add try/catch
        sender.sendMessage(movie);
        return movieRepository.save(movie);
    }
}
