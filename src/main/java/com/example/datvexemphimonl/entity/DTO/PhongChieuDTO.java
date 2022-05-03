package com.example.datvexemphimonl.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhongChieuDTO {

    private int idPhong;
    private String soPhong;
	public int getIdPhong() {
		return idPhong;
	}
	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}
	public String getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}
    
}
