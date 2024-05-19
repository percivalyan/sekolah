package com.api.sekolah.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "table_bayaran")
public class Bayaran {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bayaran")
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "id_tahun_ajaran", referencedColumnName = "id_tahun_ajaran")
    // private TahunAjaran tahunAjaran;

    // @Column(name = "kelas")
    // private String kelas;

    // @Column(name = "nomor_ruang")
    // private String nomorRuang;

    // @Column(name = "id_guru")
    // private Long idGuru;
// join kolom
    // @OneToMany(mappedBy = "siswa", cascade = CascadeType.ALL)
    // @JsonIgnore
    // private List<Spp> sppList;

    @Column(name = "nomor_transaksi")
    private Long noTransaksi;

    @Column(name = "tanggal_bayar")
    private Date tanggalBayar;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "pembayaran")
    private Long pembayaran;

     // Mengambil ManyToOne di Siswa.java
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_siswa")
    private Siswa siswa;



}
