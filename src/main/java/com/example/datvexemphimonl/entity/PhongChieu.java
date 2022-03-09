package com.example.datvexemphimonl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PhongChieu")
public class PhongChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phong")
    private int idPhong;
    @Column(name = "so_phong")
    private String soPhong;

    @OneToMany(mappedBy = "phongChieu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ghe> dsGhe;

    @OneToMany(mappedBy = "phongChieu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<XuatChieu> dsXuatChieu;

    public PhongChieu() {
    }

    public PhongChieu(int idPhong, String soPhong) {
        this.idPhong = idPhong;
        this.soPhong = soPhong;
    }
}
