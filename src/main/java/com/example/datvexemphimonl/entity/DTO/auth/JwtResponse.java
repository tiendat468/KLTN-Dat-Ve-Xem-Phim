package com.example.datvexemphimonl.entity.DTO.auth;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String sdt;

	public JwtResponse(String accessToken, String username, String sdt) {
		this.token = accessToken;
		this.username = username;
		this.sdt = sdt;

	}

}
