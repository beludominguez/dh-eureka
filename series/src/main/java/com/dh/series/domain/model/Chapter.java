package com.dh.series.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Chapter {

    @Id
    private String id;
    private String name;
    private Long number;
    private String urlStream;
}
