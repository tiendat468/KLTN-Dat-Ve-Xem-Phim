package com.example.datvexemphimonl.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoaiPhimDTO {

    private int idLoaiPhim;
    private String tenLoaiPhim;

    public LoaiPhimDTO() {
    }

    public LoaiPhimDTO(int idLoaiPhim, String tenLoaiPhim) {
        this.idLoaiPhim = idLoaiPhim;
        this.tenLoaiPhim = tenLoaiPhim;
    }

	public int getIdLoaiPhim() {
		return idLoaiPhim;
	}

	public void setIdLoaiPhim(int idLoaiPhim) {
		this.idLoaiPhim = idLoaiPhim;
	}

	public String getTenLoaiPhim() {
		return tenLoaiPhim;
	}

	public void setTenLoaiPhim(String tenLoaiPhim) {
		this.tenLoaiPhim = tenLoaiPhim;
	}
    
}

