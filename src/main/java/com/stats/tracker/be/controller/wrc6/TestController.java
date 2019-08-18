package com.stats.tracker.be.controller.wrc6;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Surface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wrc6/test")
public class TestController extends AWrc6Controller {

    @GetMapping("/surface")
    public ResponseEntity<List<Wrc6Surface>> getSurface() {

        return ResponseEntity.ok(surfaceRepo.getTest());
    }

}
