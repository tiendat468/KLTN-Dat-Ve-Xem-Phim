package com.example.datvexemphimonl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "DienVien")
public class DienVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dien_vien")
    private int idDienVien;

    @Column(name = "ten_dien_vien")
    private String tenDienVien;

    public DienVien() {
    }

    public DienVien(int idDienVien, String tenDienVien) {
        this.idDienVien = idDienVien;
        this.tenDienVien = tenDienVien;
    }

	public int getIdDienVien() {
		return idDienVien;
	}

	public void setIdDienVien(int idDienVien) {
		this.idDienVien = idDienVien;
	}

	public String getTenDienVien() {
		return tenDienVien;
	}

	public void setTenDienVien(String tenDienVien) {
		this.tenDienVien = tenDienVien;
	}
    
}
