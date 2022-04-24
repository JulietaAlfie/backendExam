package com.dh.catalogservice.api.client;

import com.dh.catalogservice.domain.model.dto.SerieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "series-service")
public interface ISerieClient {

    @GetMapping("/series/{genre}")
    ResponseEntity<List<SerieWS>> getSerieByGenre(@PathVariable String genre);


    @PostMapping
    ResponseEntity<SerieWS> saveSerie(@RequestBody SerieWS movie);
}
