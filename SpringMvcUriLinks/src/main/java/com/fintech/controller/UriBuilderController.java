package com.fintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@Controller
@RequestMapping("/uri-builder")
public class UriBuilderController {

    @GetMapping("/create-uri")
    @ResponseBody
    public String createURI() {
        String baseUrl = "http://youtube.com";
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
        RestTemplate template = new RestTemplate();
        template.setUriTemplateHandler(factory);


        URI uri = factory.uriString("/hotels/{hotel}")
                .queryParam("country", "{country}")
                .build("California", "vietnam");
        return uri.toString();
    }
}
