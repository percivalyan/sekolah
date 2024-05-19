package com.api.sekolah.service;

import com.api.sekolah.entity.Absensi;
import com.api.sekolah.repository.AbsensiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsensiService {

    @Autowired
    private AbsensiRepository absensiRepository;

    public Absensi createAbsensi(Absensi absensi) {
        return absensiRepository.save(absensi);
    }

    public void deleteAbsensi(Long id) {
        absensiRepository.deleteById(id);
    }

    public Absensi updateAbsensi(Long id, Absensi absensiDetails) {
        Optional<Absensi> absensiOptional = absensiRepository.findById(id);
        if (absensiOptional.isPresent()) {
            Absensi absensi = absensiOptional.get();
            absensi.setSakit(absensiDetails.getSakit());
            absensi.setIzin(absensiDetails.getIzin());
            absensi.setAlfa(absensiDetails.getAlfa());
            absensi.setKeterangan(absensiDetails.getKeterangan());
            absensi.setSiswa(absensiDetails.getSiswa());
            return absensiRepository.save(absensi);
        } else {
            return null; // Or handle the case where the absensi is not found
        }
    }

    public Absensi findAbsensiById(Long id) {
        return absensiRepository.findById(id).orElse(null);
    }

    public List<Absensi> findAllAbsensi() {
        return absensiRepository.findAll();
    }
}
