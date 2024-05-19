package com.api.sekolah.repository;

import com.api.sekolah.entity.Absensi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsensiRepository extends JpaRepository<Absensi, Long> {
}
