package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;

public interface CatalogService {
    CatalogWS getCatalogByGenre(String genre);
    CatalogWS saveMovie(MovieWS movie);
    CatalogWS saveSerie(SerieWS serie);
}
