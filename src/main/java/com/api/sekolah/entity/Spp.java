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
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "table_spp")
public class Spp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bayar_bulanan")
    // private Long idBayarBulanan;
    // private Long id;
    private Long id;

    @Column(name = "nomor_transaksi")
    private Long nomorTransaksi;

    @Column(name = "bulan")
    private String bulan;

    @Column(name = "lunas")
    private String lunas;

    @Column(name = "total")
    private BigDecimal total;
    
    @Column(name = "tanggal_bayaran")
    private LocalDate tanggalBayaran;

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
