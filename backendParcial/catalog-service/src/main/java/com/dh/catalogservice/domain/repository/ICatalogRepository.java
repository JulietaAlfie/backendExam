package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ICatalogRepository extends MongoRepository<CatalogWS, String> {
    Optional<CatalogWS> findByGenre(String genre);
}
