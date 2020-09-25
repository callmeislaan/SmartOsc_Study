package com.example.demo_gallery_service.controller;

import com.example.demo_gallery_service.entity.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String getGallery() {
        return "Hello gallery";
    }

    @GetMapping("/{id}")
    public Gallery getGallery(@PathVariable final int id) {
        Gallery gallery = new Gallery();
        gallery.setId(id);

        List<Object> images = restTemplate.getForObject("http://image-service/images", List.class);
        gallery.setImages(images);
        return gallery;
    }
}
