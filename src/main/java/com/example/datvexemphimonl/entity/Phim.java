package com.example.datvexemphimonl.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Phim")
public class Phim{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phim")
    private int idPhim;

    @Column(name = "ten_phim")
    private String tenPhim;

    @Column(name = "hinh")
    private String hinh;

    @Column(name = "dao_dien")
    private String daoDien;

    @Column(name = "thoi_luong")
    private int thoiLuong;

    @Column(name = "do_tuoi")
    private int doTuoi;

    @Column(name = "ngay_cong_chieu")
    private LocalDate ngayCongChieu;

    @Column(name = "quoc_gia")
    private String quocGia;

    @Column(name = "tom_tat")
    private String tomTat;

    @Column(name = "trang_thai")
    private String trangThai;

   @OneToMany
    private List<DienVien> dsDienVien;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLoaiPhim")
    private LoaiPhim loaiPhim;

    @OneToMany(mappedBy = "phim", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<XuatChieu> dsXuatChieu;

    public Phim() {
    }

	public int getIdPhim() {
		return idPhim;
	}

	public void setIdPhim(int idPhim) {
		this.idPhim = idPhim;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getDaoDien() {
		return daoDien;
	}

	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}

	public int getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public int getDoTuoi() {
		return doTuoi;
	}

	public void setDoTuoi(int doTuoi) {
		this.doTuoi = doTuoi;
	}

	public LocalDate getNgayCongChieu() {
		return ngayCongChieu;
	}

	public void setNgayCongChieu(LocalDate ngayCongChieu) {
		this.ngayCongChieu = ngayCongChieu;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public String getTomTat() {
		return tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public List<DienVien> getDsDienVien() {
		return dsDienVien;
	}

	public void setDsDienVien(List<DienVien> dsDienVien) {
		this.dsDienVien = dsDienVien;
	}

	public LoaiPhim getLoaiPhim() {
		return loaiPhim;
	}

	public void setLoaiPhim(LoaiPhim loaiPhim) {
		this.loaiPhim = loaiPhim;
	}

	public Set<XuatChieu> getDsXuatChieu() {
		return dsXuatChieu;
	}

	public void setDsXuatChieu(Set<XuatChieu> dsXuatChieu) {
		this.dsXuatChieu = dsXuatChieu;
	}


}
