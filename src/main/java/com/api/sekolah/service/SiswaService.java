package com.api.sekolah.service;

import com.api.sekolah.entity.Siswa;
import com.api.sekolah.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {

    @Autowired
    private SiswaRepository siswaRepository;

    public Siswa createSiswa(Siswa siswa) {
        return siswaRepository.save(siswa);
    }

    public void deleteSiswa(Long id) {
        siswaRepository.deleteById(id);
    }

    public Siswa updateSiswa(Long id, Siswa siswaDetails) {
        Optional<Siswa> siswaOptional = siswaRepository.findById(id);
        if (siswaOptional.isPresent()) {
            Siswa siswa = siswaOptional.get();
            siswa.setNisn(siswaDetails.getNisn());
            siswa.setNamaDepan(siswaDetails.getNamaDepan());
            siswa.setNamaBelakang(siswaDetails.getNamaBelakang());
            siswa.setTempatLahir(siswaDetails.getTempatLahir());
            siswa.setTanggalLahir(siswaDetails.getTanggalLahir());
            siswa.setJk(siswaDetails.getJk());
            siswa.setAlamat(siswaDetails.getAlamat());
            return siswaRepository.save(siswa);
        } else {
            return null; // Or handle the case where the siswa is not found
        }
    }

    public Siswa findSiswaById(Long id) {
        return siswaRepository.findById(id).orElse(null);
    }

    public List<Siswa> findAllSiswa() {
        return siswaRepository.findAll();
    }
}
