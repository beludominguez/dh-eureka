package com.dh.catalogservice.api.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document
public class Season {

    private String id;
    private Long seasonNumber;

    private List<Chapter> chapters;
}
