package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.api.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends MongoRepository<Serie, String> {

    List<Serie> findByGenre(String genre);
}
