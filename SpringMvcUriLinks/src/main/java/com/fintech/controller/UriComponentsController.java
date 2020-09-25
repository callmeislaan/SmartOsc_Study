package com.fintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/uri-components")
public class UriComponentsController {

    @GetMapping("/create-uri")
    @ResponseBody
    public String createURI() {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString("http://google.com/hotels/{hotel}")
                .queryParam("q", "{q}")
                .encode()
                .build();
        URI uri = uriComponents.expand("Westin", "123").toUri();
        return uri.toString();
    }

    @GetMapping("/create-uri-expend")
    @ResponseBody
    public String createUriExpend() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://google.com/hotels/{hotel}")
                .queryParam("q", "{q}")
                .queryParam("country", "{country}")
                .encode()
                .buildAndExpand("California", "abc", "vietnam")
                .toUri();

        return uri.toString();
    }

    @GetMapping("/create-uri-shorten")
    @ResponseBody
    public String createUriShorten() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://google.com/hotels/{hotels}")
                .queryParam("country", "{country}")
                .build("California", "vietnam");
        return uri.toString();
    }

    @GetMapping("/create-uri-shorter")
    @ResponseBody
    public String createUriShorter() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://google.com/hotels/{hotels}?country={country}")
                .build("California", "vietnam");
        return uri.toString();
    }
}
