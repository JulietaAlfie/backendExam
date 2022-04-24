package com.dh.seriesservice.domain.repository;

import com.dh.seriesservice.domain.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ISerieRepository extends MongoRepository<Serie, String> {
    public List<Serie> findAllByGenre(String genre);
}
