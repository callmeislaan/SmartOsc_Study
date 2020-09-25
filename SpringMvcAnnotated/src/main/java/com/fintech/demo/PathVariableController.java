package com.fintech.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PathVariableController {
//
//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/MatrixVariable}")
    @ResponseBody
    public String matrixHere(@MatrixVariable(name = "id", pathVar = "id") int id,
                             @MatrixVariable(name = "name", pathVar = "name") String name) {
        return "- id: " + id + " name: " + name;
    }

//    @GetMapping("/matrixParam2/{id1}/{name1}")
//    @ResponseBody
//    public String matrixHere(@MatrixVariable(name = "id",pathVar = "id1") int id,
//                             @MatrixVariable(name = "name",pathVar = "name1") String name) {
//        return "- id: " + id + " name: " + name;
//    }
//
//    @GetMapping("/matrixParam3")
//    @ResponseBody
//    public String matrixHere(@MatrixVariable(name = "id") int id, @MatrixVariable(name = "name") String name
//    , @MatrixVariable(name = "age") int age) {
//        return "- id: " + id + " name: " + name + " age: " + age;
//    }

    @GetMapping("/requestParam/requestParam")
    @ResponseBody
    public String findPet(@RequestParam(name = "petId") String petId, @RequestParam(name = "q") int q) {
        return "petId: " + petId + " q: " + q;
    }

    @ResponseBody
    @GetMapping("/requestParam/{petId}/{q}")
    public String pathVariable(@PathVariable(name = "petId") String petId, @PathVariable(name = "q") int q) {
        return "petId: " + petId + " q: " + q;
    }

    @GetMapping("/multipart")
    public String loadUploadView() {
        return "upload-view";
    }

    @PostMapping("/multipart")
    @ResponseBody
    public String getFileFromUpload(@RequestParam("file") MultipartFile file) {
        return file.getOriginalFilename();
    }

    @GetMapping("/handle")
    @ResponseBody
    public String handle(
            @RequestHeader("Accept-Encoding") String encoding,
            @RequestHeader("User-Agent") String userAgent) {
        return "encoding: " + encoding + "user Agent" + userAgent;
    }

    @GetMapping("/cookie")
    @ResponseBody
    public String handle(@CookieValue("JSESSIONID") String cookie) {
        return "JSESSIONID: " + cookie;
    }

}
