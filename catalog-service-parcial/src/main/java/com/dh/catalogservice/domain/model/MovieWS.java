package com.dh.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieWS {
    private String id;
    private String name;
    private String genre;
    private String urlStream;
}
