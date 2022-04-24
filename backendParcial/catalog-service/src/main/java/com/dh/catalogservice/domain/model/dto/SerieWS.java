package com.dh.catalogservice.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SerieWS {
    private String id;
    private String name;
    private String genre;
    private List<SeasonWS> seasons;
}
