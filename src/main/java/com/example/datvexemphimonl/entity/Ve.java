package com.example.datvexemphimonl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Ve")
public class Ve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ve")
    private int idVe;

    @Column(name = "ngay_xuat_ve")
    private Date ngayXuatVe;

    @Enumerated
    @Column(name = "code_loai_ve")
    private LoaiVe loaiVe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKhachHang")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGhe")
//    @Column(name = "id_ghe")
    private Ghe ghe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idXuatChieu")
//    @Column(name = "id_xuat_chieu")
    private XuatChieu xuatChieu;

    public Ve() {
    }

    public Ve(int idVe, Date ngayXuatVe, LoaiVe loaiVe) {
        this.idVe = idVe;
        this.ngayXuatVe = ngayXuatVe;
        this.loaiVe = loaiVe;
    }
}
