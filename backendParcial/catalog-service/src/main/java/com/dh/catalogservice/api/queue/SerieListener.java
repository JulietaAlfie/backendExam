package com.dh.catalogservice.api.queue;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.impl.CatalogServiceImpl;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SerieListener {

    private final CatalogServiceImpl catalogService;

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receive(@Payload SerieWS serie){
        log.info("Saving serie " + serie.getName());
        catalogService.saveSerie(serie);
    }
}
