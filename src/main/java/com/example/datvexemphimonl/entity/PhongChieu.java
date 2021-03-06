package com.example.datvexemphimonl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PhongChieu")
public class PhongChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phong")
    private int idPhong;
    @Column(name = "ten_phong")
    private String tenPhong;

    @OneToMany(mappedBy = "phongChieu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ghe> dsGhe;

    @OneToMany(mappedBy = "phongChieu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<XuatChieu> dsXuatChieu;

    public PhongChieu() {
    }

    public PhongChieu(int idPhong, String tenPhong) {
        this.idPhong = idPhong;
        this.tenPhong = tenPhong;
    }

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public Set<Ghe> getDsGhe() {
		return dsGhe;
	}

	public void setDsGhe(Set<Ghe> dsGhe) {
		this.dsGhe = dsGhe;
	}

	public Set<XuatChieu> getDsXuatChieu() {
		return dsXuatChieu;
	}

	public void setDsXuatChieu(Set<XuatChieu> dsXuatChieu) {
		this.dsXuatChieu = dsXuatChieu;
	}
    
}
