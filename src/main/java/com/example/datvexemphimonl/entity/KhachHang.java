package com.example.datvexemphimonl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_khach_hang")
    private int idKhachHang;

    @Column(name = "ten_khach_hang")
    private String tenKhachHang;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "thanh_toan")
    private String thongTinThanhToan;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ve> dsVe;

    public KhachHang() {
    }

    public KhachHang(int idKhachHang, String tenKhachHang, Date ngaySinh, String sdt, String matKhau, String thongTinThanhToan) {
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.thongTinThanhToan = thongTinThanhToan;
    }
}
