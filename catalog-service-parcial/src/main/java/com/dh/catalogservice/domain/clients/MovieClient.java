package com.dh.catalogservice.domain.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("movie-service")
public interface MovieClient {

    @RequestMapping("/movies/test")
    String test();
}
