package com.example.datvexemphimonl.entity.DTO.auth;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {

	private String tenKhachHang;
	private String sdt;
	private String type = "Bearer";
	private String token;

	public JwtResponse(String tenKhachHang, String sdt, String token) {
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.token = token;
	}
}
