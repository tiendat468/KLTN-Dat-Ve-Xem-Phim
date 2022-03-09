package com.example.datvexemphimonl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "XuatChieu")
public class XuatChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_xuat_chieu")
    private int idXuatChieu;

    @Column(name = "ngay_chieu")
    private Date ngayChieu;

    @Column(name = "thoi_gian_bat_dau")
    private String thoiGianBatDau;

    @Column(name = "thoi_gian_ket_thuc")
    private String thoiGianKetThuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPhim")
    private Phim phim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPhong")
    private PhongChieu phongChieu;

    public XuatChieu() {
    }

    public XuatChieu(int idXuatChieu, Date ngayChieu, String thoiGianBatDau, String thoiGianKetThuc) {
        this.idXuatChieu = idXuatChieu;
        this.ngayChieu = ngayChieu;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }
}
