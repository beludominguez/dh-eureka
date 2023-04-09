package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.api.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends MongoRepository<Series, String> {

    List<Series> findByGenre(String genre);
}
