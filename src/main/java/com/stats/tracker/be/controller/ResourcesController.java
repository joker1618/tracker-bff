package com.stats.tracker.be.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static xxx.joker.libs.core.utils.JkStrings.strf;

@RestController
@RequestMapping("/resources")
public class ResourcesController extends AbstractController {

    @GetMapping(value = "/flag", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getCountryFlag(@RequestParam("countryName") String countryName) throws IOException {

        ClassPathResource cpres = new ClassPathResource(strf("images/flags/{}.png", countryName));
        byte[] bytes = StreamUtils.copyToByteArray(cpres.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }

    @GetMapping("/stageMap")
    public void getStageMap() {
        //todo impl
    }



}
