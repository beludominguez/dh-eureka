package com.dh.catalogservice.api.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Serie {

    private String id;
    private String name;
    private String genre;

    private List<Season> seasons;
}
