package com.api.sekolah.entity;
// package com.api.sekolah.entity;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
// import lombok.Data;
// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// @Data
// @Entity
// @Table(name = "table_tahun_ajaran")
// public class TahunAjaran {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id_tahun_ajaran")
//     private Long id;

//     @Column(name = "tahun_ajaran")
//     private String tahunAjaran;
 
//     @Column(name = "status")
//     private String status;

//     @OneToMany(mappedBy = "tahunAjaran", cascade = CascadeType.ALL)
//     @JsonIgnore
//     private List<Spp> sppList;
// }
