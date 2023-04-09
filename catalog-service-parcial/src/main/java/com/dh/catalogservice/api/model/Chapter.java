package com.dh.catalogservice.api.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Chapter {

    private String id;
    private String name;
    private Long number;
    private String urlStream;
}
