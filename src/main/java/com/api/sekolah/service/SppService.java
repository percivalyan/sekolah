package com.api.sekolah.service;

import com.api.sekolah.entity.Spp;
import com.api.sekolah.entity.Siswa;
import com.api.sekolah.repository.SppRepository;
import com.api.sekolah.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SppService {

    @Autowired
    private SppRepository sppRepository;

    @Autowired
    private SiswaRepository siswaRepository;

    @Transactional
    public Spp createSpp(Spp spp) {
        // Ensure the Siswa entity is managed before saving Spp
        Siswa siswa = spp.getSiswa();
        if (siswa != null && siswa.getId() != null) {
            // Merge the Siswa entity if it's detached
            siswa = siswaRepository.findById(siswa.getId()).orElse(siswa);
        }
        spp.setSiswa(siswa);
        return sppRepository.save(spp);
    }

    @Transactional
    public Spp updateSpp(Long id, Spp sppDetails) {
        Optional<Spp> sppOptional = sppRepository.findById(id);
        if (sppOptional.isPresent()) {
            Spp spp = sppOptional.get();
            spp.setNomorTransaksi(sppDetails.getNomorTransaksi());
            spp.setBulan(sppDetails.getBulan());
            spp.setLunas(sppDetails.getLunas());
            spp.setTotal(sppDetails.getTotal());
            spp.setTanggalBayaran(sppDetails.getTanggalBayaran());

            Siswa siswaDetails = sppDetails.getSiswa();
            if (siswaDetails != null && siswaDetails.getId() != null) {
                // Merge the Siswa entity if it's detached
                Siswa siswa = siswaRepository.findById(siswaDetails.getId()).orElse(siswaDetails);
                spp.setSiswa(siswa);
            } else {
                spp.setSiswa(siswaDetails);
            }

            return sppRepository.save(spp);
        } else {
            return null; // Or handle the case where the Spp is not found
        }
    }

    public void deleteSpp(Long id) {
        sppRepository.deleteById(id);
    }

    public Spp findSppById(Long id) {
        return sppRepository.findById(id).orElse(null);
    }

    public List<Spp> findAllSpp() {
        return sppRepository.findAll();
    }
}
