package com.example.datvexemphimonl.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GheDTO {
    private int idGhe;
    private String hangGhe;
    private String cotGhe;
    private PhongChieuDTO phongChieu;

    public GheDTO() {
    }

	public int getIdGhe() {
		return idGhe;
	}

	public void setIdGhe(int idGhe) {
		this.idGhe = idGhe;
	}

	public String getHangGhe() {
		return hangGhe;
	}

	public void setHangGhe(String hangGhe) {
		this.hangGhe = hangGhe;
	}

	public String getCotGhe() {
		return cotGhe;
	}

	public void setCotGhe(String cotGhe) {
		this.cotGhe = cotGhe;
	}

	public PhongChieuDTO getPhongChieu() {
		return phongChieu;
	}

	public void setPhongChieu(PhongChieuDTO phongChieu) {
		this.phongChieu = phongChieu;
	}
    
}
