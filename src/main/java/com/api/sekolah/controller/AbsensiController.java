package com.api.sekolah.controller;

import com.api.sekolah.entity.Absensi;
import com.api.sekolah.service.AbsensiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/absensi")
public class AbsensiController {

    @Autowired
    private AbsensiService absensiService;

    @PostMapping
    public ResponseEntity<Absensi> createAbsensi(@RequestBody Absensi absensi) {
        Absensi createdAbsensi = absensiService.createAbsensi(absensi);
        return ResponseEntity.ok(createdAbsensi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsensi(@PathVariable Long id) {
        absensiService.deleteAbsensi(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Absensi> updateAbsensi(@PathVariable Long id, @RequestBody Absensi absensiDetails) {
        Absensi updatedAbsensi = absensiService.updateAbsensi(id, absensiDetails);
        if (updatedAbsensi == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedAbsensi);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Absensi> getAbsensiById(@PathVariable Long id) {
        Absensi absensi = absensiService.findAbsensiById(id);
        if (absensi == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(absensi);
        }
    }

    @GetMapping
    public ResponseEntity<List<Absensi>> getAllAbsensi() {
        List<Absensi> absensiList = absensiService.findAllAbsensi();
        return ResponseEntity.ok(absensiList);
    }
}
