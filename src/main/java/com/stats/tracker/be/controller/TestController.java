package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.jpa.entities.*;
import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcSurface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController extends AbstractController {

    @GetMapping("/surf")
    public ResponseEntity<List<WrcSurface>> getTest() {
        return ResponseEntity.ok(surfaceRepo.getTest());
    }

}
