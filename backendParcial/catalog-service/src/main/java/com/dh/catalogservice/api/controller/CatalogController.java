package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequestMapping("/catalog")
public class CatalogController {
	private CatalogService catalogService;

	@Autowired
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	ResponseEntity<CatalogWS> getCatalogByGenre(@PathVariable String genre) {
		log.info("Se busco el catalogo con el genero " + genre);
		return ResponseEntity.ok().body(catalogService.getCatalogByGenre(genre));
	}

//	@PostMapping("/series")
//	ResponseEntity<CatalogWS> addSerie(@RequestBody SerieWS serie){
//		return ResponseEntity.ok(catalogService.saveSerie(serie));
//	}
//
//	@PostMapping("/movie")
//	ResponseEntity<CatalogWS> addMovie(@RequestBody MovieWS movie){
//		return ResponseEntity.ok(catalogService.saveMovie(movie));
//	}
}
