package com.api.sekolah.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "table_absensi")
public class Absensi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_absensi")
    // private Long idBayarBulanan;
    // private Long id;
    private Long id;

    @Column(name = "sakit")
    private String sakit;

    @Column(name = "izin")
    private String izin;

    @Column(name = "alfa")
    private String alfa;

    @Column(name = "keterangan")
    private String keterangan;

    // Mengambil OneToOne di Siswa.java
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_siswa")
    private Siswa siswa;

    // @OneToOne
    // @MapsId
    // @JoinColumn(name = "id_siswa")
    // private Siswa siswa;


    // @ManyToOne
    // @JoinColumn(name = "id_siswa", referencedColumnName = "id_siswa")
    // private Siswa siswa;

    // @ManyToOne
    // @JoinColumn(name = "id_tahun_ajaran", referencedColumnName = "id_tahun_ajaran")
    // private TahunAjaran tahunAjaran;
}
