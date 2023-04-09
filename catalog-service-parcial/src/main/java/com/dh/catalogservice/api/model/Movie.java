package com.dh.catalogservice.api.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Movie {

    private String id;
    private String name;
    private String genre;
    private String urlStream;
}
