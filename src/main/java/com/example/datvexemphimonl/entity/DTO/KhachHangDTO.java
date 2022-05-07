package com.example.datvexemphimonl.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;

@Getter
@Setter
public class KhachHangDTO {
    private int idKhachHang;
    private String tenKhachHang;
    private LocalDate ngaySinh;
    private String sdt;
	private String email;
	private String verification_code;
	private boolean enabled;
    private String thongTinThanhToan;



    public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerification_code() {
		return verification_code;
	}

	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}

}

