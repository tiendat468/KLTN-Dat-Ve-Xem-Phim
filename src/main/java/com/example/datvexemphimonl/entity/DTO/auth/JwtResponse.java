package com.example.datvexemphimonl.entity.DTO.auth;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {

	private int id;
	private String tenKhachHang;
	private String sdt;
	private String type = "Bearer";
	private String token;

	public JwtResponse(int id, String tenKhachHang, String sdt, String token) {
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.token = token;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
