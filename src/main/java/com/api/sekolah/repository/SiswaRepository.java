package com.api.sekolah.repository;

import com.api.sekolah.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long> {
    // Jika diperlukan, tambahkan method kustom di sini
}
