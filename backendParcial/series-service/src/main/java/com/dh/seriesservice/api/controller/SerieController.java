package com.dh.seriesservice.api.controller;

import com.dh.seriesservice.api.queue.SerieSender;
import com.dh.seriesservice.api.service.ISerieService;
import com.dh.seriesservice.domain.model.Serie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
@AllArgsConstructor
@Slf4j
public class SerieController {

    private ISerieService serieService;
    private SerieSender serieSender;

    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre){
        return ResponseEntity.ok().body(serieService.getSeriesByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie){
        serieSender.send(serieService.saveSerie(serie));
        log.info("Saved serie");
        return ResponseEntity.ok().body(serieService.saveSerie(serie));
    }
}
