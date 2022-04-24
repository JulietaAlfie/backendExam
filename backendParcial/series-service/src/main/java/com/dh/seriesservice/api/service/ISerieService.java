package com.dh.seriesservice.api.service;

import com.dh.seriesservice.domain.model.Serie;

import java.util.List;

public interface ISerieService {
    List<Serie> getSeriesByGenre(String genre);
    Serie saveSerie(Serie serie);
}
