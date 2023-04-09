package com.dh.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatalogWS {
    private String genre;
    private List<MovieWS> movies;
    private List<SerieWS> series;
}
