package com.dh.catalogservice.domain.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("catalog")
public class CatalogWS {
    @Id
    private String genre;
    private List<MovieWS> movies;
    private List<SerieWS> series;

    public CatalogWS(String genre, List<MovieWS> movies, List<SerieWS> series) {
        this.genre = genre;
        this.movies = movies;
        this.series = series;
    }
}
