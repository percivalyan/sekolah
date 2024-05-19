package com.api.sekolah.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.cglib.core.Local;

@Data
@Entity
@Table(name = "table_siswa")
public class Siswa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siswa")
    private Long id;

    @Column(name = "nisn")
    private String nisn;

    @Column(name = "nama_depan")
    private String namaDepan;

    @Column(name = "nama_belakang")
    private String namaBelakang;

    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @Column(name = "tanggal_lahir")
    private LocalDate tanggalLahir;

    @Column(name = "jenis_kelamin")
    private String jk;

    @Column(name = "alamat")
    private String alamat;

    // Tidak menggunakan Mapped By
    // @OneToMany(mappedBy = "siswa", cascade = CascadeType.ALL)
    // @JsonIgnore
    // private List<Spp> sppList;

    // @OneToOne(mappedBy = "spp", cascade = CascadeType.ALL)
    // @PrimaryKeyJoinColumn
    // private Spp spp;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "id_spp")
    // private Spp spp;
}
