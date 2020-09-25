package com.fintech.controller;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.net.URL;

@Controller
@RequestMapping("/uri-encoding")
public class UriEncodingController {

    @GetMapping("/uri-components-builder-encoding")
    @ResponseBody
    public String createUriComponentsBuilderEncoding() {
        URI uri = UriComponentsBuilder.fromPath("/hotel list/{city}")
                .queryParam("country", "{country}")
                .encode()
                .buildAndExpand("Ha Noi", "Viet Nam")
                .toUri();
        return uri.toString();
    }

    @GetMapping("/uri-components-builder-encoding-shorten")
    @ResponseBody
    public String createUriComponentsBuilderEncodingShorten() {
        URI uri = UriComponentsBuilder.fromPath("/hotel list/{city}")
                .queryParam("country", "{country}")
                .build("Ha Noi", "Viet Nam");
        return uri.toString();
    }

    @GetMapping("/test-encoding-mode")
    @ResponseBody
    public String testEncoding() {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
        URI uri = factory.uriString("/my-home/{province}")
                .queryParam("country", "{country}")
                .fragment("abc")
                .userInfo("phuoc")
                .port(1234)
                .scheme("fpt")
                .path("my-path")
                .build("Nam Dinh", "Viet Nam");
        return uri.toString();
    }

    @GetMapping("/test-encoding-mode-1")
//    @ResponseBody
    public URI testEncoding1() {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
        URI uri = factory.uriString("/uri-encoding/{path}")
                .userInfo("http")
                .build("test-encoding-mode");
        return uri;
    }

}
