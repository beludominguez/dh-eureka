package com.dh.catalogservice.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterWS {

    private Long id;
    private String name;
    private Long number;
    private String urlStream;
}
