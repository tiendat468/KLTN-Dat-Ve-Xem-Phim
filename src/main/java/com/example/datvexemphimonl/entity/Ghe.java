package com.example.datvexemphimonl.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Ghe")
public class Ghe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ghe")
    private int idGhe;
    @Column(name = "hang_ghe")
    private String hangGhe;
    @Column(name = "cot_ghe")
    private String cotGhe;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPhong")
    private PhongChieu phongChieu;


    public Ghe() {
    }

    public Ghe(int idGhe, String hangGhe, String cotGhe) {
        this.idGhe = idGhe;
        this.hangGhe = hangGhe;
        this.cotGhe = cotGhe;
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

	public PhongChieu getPhongChieu() {
		return phongChieu;
	}

	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}
    
}
