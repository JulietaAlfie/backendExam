package com.dh.catalogservice.api.client;

import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "movie-service")
public interface IMovieClient {

    @GetMapping("/movies/{genre}")
    ResponseEntity<List<MovieWS>> getMovieByGenre(@PathVariable String genre);

    @PostMapping
    ResponseEntity<MovieWS> saveMovie(@RequestBody MovieWS movie);

}
