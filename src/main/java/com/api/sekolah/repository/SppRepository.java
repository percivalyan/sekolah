package com.api.sekolah.repository;

import com.api.sekolah.entity.Spp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SppRepository extends JpaRepository<Spp, Long> {
    // Jika diperlukan, tambahkan method kustom di sini
}
