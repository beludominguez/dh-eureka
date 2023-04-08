package com.dh.catalogservice.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeasonWS {

    private Long id;
    private Long seasonNumber;
    private List<ChapterWS> chapters;
}