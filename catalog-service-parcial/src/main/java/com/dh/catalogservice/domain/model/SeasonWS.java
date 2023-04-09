package com.dh.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeasonWS {

    private String id;
    private Long seasonNumber;
    private List<ChapterWS> chapters;
}
