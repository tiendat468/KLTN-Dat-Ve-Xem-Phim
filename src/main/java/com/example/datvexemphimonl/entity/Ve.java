package com.example.datvexemphimonl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate ngayXuatVe;

    @Enumerated
    @Column(name = "loai_ve")
    private LoaiVe loaiVe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKhachHang")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGhe")
    private Ghe ghe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idXuatChieu")
    private XuatChieu xuatChieu;

    public Ve() {
    }

    public Ve(int idVe, LocalDate ngayXuatVe, LoaiVe loaiVe) {
        this.idVe = idVe;
        this.ngayXuatVe = ngayXuatVe;
        this.loaiVe = loaiVe;
    }

	public int getIdVe() {
		return idVe;
	}

	public void setIdVe(int idVe) {
		this.idVe = idVe;
	}

	public LocalDate getNgayXuatVe() {
		return ngayXuatVe;
	}

	public void setNgayXuatVe(LocalDate ngayXuatVe) {
		this.ngayXuatVe = ngayXuatVe;
	}

	public LoaiVe getLoaiVe() {
		return loaiVe;
	}

	public void setLoaiVe(LoaiVe loaiVe) {
		this.loaiVe = loaiVe;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Ghe getGhe() {
		return ghe;
	}

	public void setGhe(Ghe ghe) {
		this.ghe = ghe;
	}

	public XuatChieu getXuatChieu() {
		return xuatChieu;
	}

	public void setXuatChieu(XuatChieu xuatChieu) {
		this.xuatChieu = xuatChieu;
	}
    
}
