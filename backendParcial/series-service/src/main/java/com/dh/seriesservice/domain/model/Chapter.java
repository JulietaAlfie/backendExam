package com.dh.seriesservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chapter {
    private String name;
    private int number;
    private String urlStream;
}
