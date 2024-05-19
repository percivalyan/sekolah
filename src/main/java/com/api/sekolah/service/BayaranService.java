package com.api.sekolah.service;

import com.api.sekolah.entity.Bayaran;
import com.api.sekolah.entity.Siswa;
import com.api.sekolah.repository.BayaranRepository;
import com.api.sekolah.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BayaranService {

    @Autowired
    private BayaranRepository bayaranRepository;

    @Autowired
    private SiswaRepository siswaRepository;

    @Transactional
    public Bayaran createBayaran(Bayaran bayaran) {
        // Ensure the Siswa entity is managed before saving Bayaran
        Siswa siswa = bayaran.getSiswa();
        if (siswa != null && siswa.getId() != null) {
            // Merge the Siswa entity if it's detached
            siswa = siswaRepository.findById(siswa.getId()).orElse(siswa);
        }
        bayaran.setSiswa(siswa);
        return bayaranRepository.save(bayaran);
    }

    @Transactional
    public Bayaran updateBayaran(Long id, Bayaran bayaranDetails) {
        Optional<Bayaran> bayaranOptional = bayaranRepository.findById(id);
        if (bayaranOptional.isPresent()) {
            Bayaran bayaran = bayaranOptional.get();
            bayaran.setNoTransaksi(bayaranDetails.getNoTransaksi());
            bayaran.setTanggalBayar(bayaranDetails.getTanggalBayar());
            bayaran.setTotal(bayaranDetails.getTotal());
            bayaran.setPembayaran(bayaranDetails.getPembayaran());

            Siswa siswaDetails = bayaranDetails.getSiswa();
            if (siswaDetails != null && siswaDetails.getId() != null) {
                // Merge the Siswa entity if it's detached
                Siswa siswa = siswaRepository.findById(siswaDetails.getId()).orElse(siswaDetails);
                bayaran.setSiswa(siswa);
            } else {
                bayaran.setSiswa(siswaDetails);
            }

            return bayaranRepository.save(bayaran);
        } else {
            return null; // Or handle the case where the Bayaran is not found
        }
    }

    public void deleteBayaran(Long id) {
        bayaranRepository.deleteById(id);
    }

    public Bayaran findBayaranById(Long id) {
        return bayaranRepository.findById(id).orElse(null);
    }

    public List<Bayaran> findAllBayaran() {
        return bayaranRepository.findAll();
    }
}
