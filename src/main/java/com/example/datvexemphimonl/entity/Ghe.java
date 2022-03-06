package com.example.datvexemphimonl.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Ghe")
public class Ghe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ghe")
    private int idGhe;
    @Column(name = "hang_ghe")
    private String hangGhe;
    @Column(name = "cot_ghe")
    private String cotGhe;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPhong")
//    @Column(name = "id_phong")
    private PhongChieu phongChieu;

    public Ghe() {
    }

    public Ghe(int idGhe, String hangGhe, String cotGhe) {
        this.idGhe = idGhe;
        this.hangGhe = hangGhe;
        this.cotGhe = cotGhe;
    }
}
