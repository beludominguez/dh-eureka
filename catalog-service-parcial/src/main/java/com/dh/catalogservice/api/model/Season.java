package com.dh.catalogservice.api.model;

import lombok.Data;

import java.util.List;
@Data

public class Season {

    private String id;
    private Long seasonNumber;

    private List<Chapter> chapters;
}
