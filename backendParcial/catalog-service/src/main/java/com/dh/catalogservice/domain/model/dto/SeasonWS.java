package com.dh.catalogservice.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SeasonWS {
    private int seasonNumber;
    private List<ChapterWS> chapters;
}
