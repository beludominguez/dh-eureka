package com.dh.catalogservice.domain.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("movie-client")
public interface MovieClient {

    @RequestMapping("/test")
    String test();
}
