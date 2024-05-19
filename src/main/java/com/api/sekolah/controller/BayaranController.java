package com.api.sekolah.controller;

import com.api.sekolah.entity.Bayaran;
import com.api.sekolah.service.BayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bayaran")
public class BayaranController {

    @Autowired
    private BayaranService bayaranService;

    @PostMapping
    public ResponseEntity<Bayaran> createBayaran(@RequestBody Bayaran bayaran) {
        Bayaran createdBayaran = bayaranService.createBayaran(bayaran);
        return ResponseEntity.ok(createdBayaran);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBayaran(@PathVariable Long id) {
        bayaranService.deleteBayaran(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bayaran> updateBayaran(@PathVariable Long id, @RequestBody Bayaran bayaranDetails) {
        Bayaran updatedBayaran = bayaranService.updateBayaran(id, bayaranDetails);
        if (updatedBayaran == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedBayaran);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bayaran> getBayaranById(@PathVariable Long id) {
        Bayaran bayaran = bayaranService.findBayaranById(id);
        if (bayaran == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bayaran);
        }
    }

    @GetMapping
    public ResponseEntity<List<Bayaran>> getAllBayaran() {
        List<Bayaran> bayaranList = bayaranService.findAllBayaran();
        return ResponseEntity.ok(bayaranList);
    }
}
