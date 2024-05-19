package com.api.sekolah.controller;

import com.api.sekolah.entity.Siswa;
import com.api.sekolah.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siswa")
public class SiswaController {

    @Autowired
    private SiswaService siswaService;

    @PostMapping
    public ResponseEntity<Siswa> createSiswa(@RequestBody Siswa siswa) {
        Siswa createdSiswa = siswaService.createSiswa(siswa);
        return ResponseEntity.ok(createdSiswa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSiswa(@PathVariable Long id) {
        siswaService.deleteSiswa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Siswa> updateSiswa(@PathVariable Long id, @RequestBody Siswa siswaDetails) {
        Siswa updatedSiswa = siswaService.updateSiswa(id, siswaDetails);
        if (updatedSiswa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedSiswa);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Siswa> getSiswaById(@PathVariable Long id) {
        Siswa siswa = siswaService.findSiswaById(id);
        if (siswa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(siswa);
        }
    }

    @GetMapping
    public ResponseEntity<List<Siswa>> getAllSiswa() {
        List<Siswa> siswaList = siswaService.findAllSiswa();
        return ResponseEntity.ok(siswaList);
    }
}
