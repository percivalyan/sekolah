package com.api.sekolah.repository;

import com.api.sekolah.entity.Bayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BayaranRepository extends JpaRepository<Bayaran, Long> {
    // Jika diperlukan, tambahkan method kustom di sini
}
