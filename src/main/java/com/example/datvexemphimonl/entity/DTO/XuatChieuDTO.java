package com.example.datvexemphimonl.entity.DTO;

import com.example.datvexemphimonl.entity.PhongChieu;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class XuatChieuDTO {

    private int idXuatChieu;
    private LocalDate ngayChieu;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private PhimDTO phim;
    private PhongChieuDTO phongChieu;
	public int getIdXuatChieu() {
		return idXuatChieu;
	}
	public void setIdXuatChieu(int idXuatChieu) {
		this.idXuatChieu = idXuatChieu;
	}
	public LocalDate getNgayChieu() {
		return ngayChieu;
	}
	public void setNgayChieu(LocalDate ngayChieu) {
		this.ngayChieu = ngayChieu;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public PhimDTO getPhim() {
		return phim;
	}
	public void setPhim(PhimDTO phim) {
		this.phim = phim;
	}
	public PhongChieuDTO getPhongChieu() {
		return phongChieu;
	}
	public void setPhongChieu(PhongChieuDTO phongChieu) {
		this.phongChieu = phongChieu;
	}
    
}
