package com.dh.series.domain.repository;

import com.dh.series.domain.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends MongoRepository<Serie, String> {

    List<Serie> findByGenre(String genre);
}
