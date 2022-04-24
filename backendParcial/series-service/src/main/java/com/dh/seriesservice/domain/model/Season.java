package com.dh.seriesservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Season {
    private int seasonNumber;
    private List<Chapter> chapters;
}
