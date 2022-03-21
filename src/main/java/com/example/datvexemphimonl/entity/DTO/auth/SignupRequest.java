package com.example.datvexemphimonl.entity.DTO.auth;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SignupRequest {

	private String tenKhachHang;
	private String sdt;
	private String matKhau;
	private Set<String> roles;

}
