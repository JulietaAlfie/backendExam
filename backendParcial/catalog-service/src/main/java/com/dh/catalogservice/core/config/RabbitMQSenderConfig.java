package com.dh.catalogservice.core.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.movie.name}")
    private String movieQueue;
    @Value("${queue.serie.name}")
    private String serieQueue;


    @Bean
    public Queue queue(){
        return new Queue(movieQueue,true);
    }



    @Bean
    public Queue queueSerie(){
        return new Queue(serieQueue,true);
    }
}
