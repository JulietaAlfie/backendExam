package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import com.dh.catalogservice.api.client.IMovieClient;
import com.dh.catalogservice.api.client.ISerieClient;
import com.dh.catalogservice.domain.repository.ICatalogRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {

	private IMovieClient movieClient;
	private ISerieClient serieClient;
	private ICatalogRepository catalogRepository;

	@Autowired
	public CatalogServiceImpl(IMovieClient movieClient, ISerieClient serieClient, ICatalogRepository catalogRepository) {
		this.movieClient = movieClient;
		this.serieClient = serieClient;
		this.catalogRepository = catalogRepository;
	}

	@CircuitBreaker(name = "getCatalog", fallbackMethod = "fallbackGetCatalog")
	@Retry(name = "getCatalog")
	public CatalogWS getCatalogByGenre(String genre){
		List<SerieWS> seriesWS = serieClient.getSerieByGenre(genre).getBody();
		List<MovieWS> moviesWS = movieClient.getMovieByGenre(genre).getBody();
		log.info("Encontrando catalogo con genero: " + genre);
		return catalogRepository.findByGenre(genre).orElse(catalogRepository.save(new CatalogWS(genre, moviesWS, seriesWS)));
	}

	@Override
	public CatalogWS saveMovie(MovieWS movie) {
		CatalogWS catalog = getCatalogByGenre(movie.getGenre());

		catalog.getMovies().add(movie);
		log.info("Saving movie: " + movie.getName());
		return catalogRepository.save(catalog);
	}

	@Override
	public CatalogWS saveSerie(SerieWS serie) {
		CatalogWS catalog = getCatalogByGenre(serie.getGenre());
		catalog.getSeries().add(serie);
		log.info("Saving serie: " + serie.getName());
		return catalogRepository.save(catalog);
	}

	private CatalogWS fallbackGetCatalog(CallNotPermittedException callNotPermittedException){
		return new CatalogWS("", Collections.<MovieWS>emptyList(), Collections.<SerieWS>emptyList());
	}

}
