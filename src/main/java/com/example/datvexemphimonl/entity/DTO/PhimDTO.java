package com.example.datvexemphimonl.entity.DTO;

import com.example.datvexemphimonl.entity.DienVien;
import com.example.datvexemphimonl.entity.LoaiPhim;
import com.example.datvexemphimonl.entity.XuatChieu;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PhimDTO {
    private int idPhim;
    private String tenPhim;
    private String hinh;
    private String daoDien;
    private int thoiLuong;
    private int doTuoi;
    private LocalDate ngayCongChieu;
    private String quocGia;
    private String tomTat;
    private String trangThai;
    private LoaiPhimDTO loaiPhim;
    private List<DienVien> dsDienVien;


    public PhimDTO() {
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


	public LoaiPhimDTO getLoaiPhim() {
		return loaiPhim;
	}


	public void setLoaiPhim(LoaiPhimDTO loaiPhim) {
		this.loaiPhim = loaiPhim;
	}


	public List<DienVien> getDsDienVien() {
		return dsDienVien;
	}


	public void setDsDienVien(List<DienVien> dsDienVien) {
		this.dsDienVien = dsDienVien;
	}


}
