package com.dh.catalogservice.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieWS {
    private Integer id;
    private String name;
    private String genre;
    private String urlStream;
}