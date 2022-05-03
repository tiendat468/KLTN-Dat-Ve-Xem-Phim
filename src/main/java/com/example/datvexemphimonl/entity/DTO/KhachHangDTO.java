package com.example.datvexemphimonl.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class KhachHangDTO {
    private int idKhachHang;
    private String tenKhachHang;
    private LocalDate ngaySinh;
    private String sdt;
    private String thongTinThanhToan;

    public KhachHangDTO() {
    }

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getThongTinThanhToan() {
		return thongTinThanhToan;
	}

	public void setThongTinThanhToan(String thongTinThanhToan) {
		this.thongTinThanhToan = thongTinThanhToan;
	}
    
}

