package com.api.sekolah.controller;

import com.api.sekolah.entity.Spp;
import com.api.sekolah.service.SppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spp")
public class SppController {

    @Autowired
    private SppService sppService;

    @PostMapping
    public ResponseEntity<Spp> createSpp(@RequestBody Spp spp) {
        Spp createdSpp = sppService.createSpp(spp);
        return ResponseEntity.ok(createdSpp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpp(@PathVariable Long id) {
        sppService.deleteSpp(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Spp> updateSpp(@PathVariable Long id, @RequestBody Spp sppDetails) {
        Spp updatedSpp = sppService.updateSpp(id, sppDetails);
        if (updatedSpp == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedSpp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spp> getSppById(@PathVariable Long id) {
        Spp spp = sppService.findSppById(id);
        if (spp == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(spp);
        }
    }

    @GetMapping
    public ResponseEntity<List<Spp>> getAllSpp() {
        List<Spp> sppList = sppService.findAllSpp();
        return ResponseEntity.ok(sppList);
    }
}
