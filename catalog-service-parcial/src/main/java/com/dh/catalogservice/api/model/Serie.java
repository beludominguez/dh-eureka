package com.dh.catalogservice.api.model;

import lombok.Data;

import java.util.List;

@Data
public class Serie {

    private Long id;
    private String name;
    private String genre;

    private List<Season> seasons;
}
