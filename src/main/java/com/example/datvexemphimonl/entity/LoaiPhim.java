package com.example.datvexemphimonl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "LoaiPhim")
public class LoaiPhim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai_phim")
    private int idLoaiPhim;
    @Column(name = "ten_loai_phim")
    private String tenLoaiPhim;

    @OneToMany(mappedBy = "loaiPhim")
    private List<Phim> dsPhim;

    public LoaiPhim() {
    }

    public LoaiPhim(int idLoaiPhim, String tenLoaiPhim) {
        this.idLoaiPhim = idLoaiPhim;
        this.tenLoaiPhim = tenLoaiPhim;
    }
}
