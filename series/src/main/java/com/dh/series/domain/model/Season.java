package com.dh.series.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Season {

    @Id
    private String id;
    private Long seasonNumber;

    private List<Chapter> chapters;
}
