package com.dh.seriesservice.api.service.impl;

import com.dh.seriesservice.api.service.ISerieService;
import com.dh.seriesservice.domain.model.Serie;
import com.dh.seriesservice.domain.repository.ISerieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SerieServiceImpl implements ISerieService {

    private ISerieRepository serieRepository;

    @Override
    public List<Serie> getSeriesByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    @Override
    public Serie saveSerie(Serie serie) {
        return serieRepository.save(serie);
    }
}
