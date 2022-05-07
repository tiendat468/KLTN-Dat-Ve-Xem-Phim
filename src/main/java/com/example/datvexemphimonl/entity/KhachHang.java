package com.example.datvexemphimonl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "KhachHang")
public class KhachHang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_khach_hang")
	private int idKhachHang;

	@Column(name = "ten_khach_hang")
	private String tenKhachHang;

	@Column(name = "ngay_sinh")
	private LocalDate ngaySinh;

	@Column(name = "sdt")
	private String sdt;

	@Column(name = "mat_khau")
	private String matKhau;

	@Column(name = "email")
	private String email;

	@Column
	private String verification_code;

	@Column
	private boolean enabled;

	private String token;

	@Column(name = "thanh_toan")
	private String thongTinThanhToan;

	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Ve> dsVe;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "khachhang_role", joinColumns = @JoinColumn(name = "id_khach_hang"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	private Set<Role> roles = new HashSet<>();

	public KhachHang() {
	}

	public KhachHang(int idKhachHang, String tenKhachHang, LocalDate ngaySinh, String sdt, String matKhau, String email,
			String verification_code, boolean enabled, String token, String thongTinThanhToan, List<Ve> dsVe,
			Set<Role> roles) {
		super();
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.matKhau = matKhau;
		this.email = email;
		this.verification_code = verification_code;
		this.enabled = enabled;
		this.token = token;
		this.thongTinThanhToan = thongTinThanhToan;
		this.dsVe = dsVe;
		this.roles = roles;
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getThongTinThanhToan() {
		return thongTinThanhToan;
	}

	public void setThongTinThanhToan(String thongTinThanhToan) {
		this.thongTinThanhToan = thongTinThanhToan;
	}

	public List<Ve> getDsVe() {
		return dsVe;
	}

	public void setDsVe(List<Ve> dsVe) {
		this.dsVe = dsVe;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerification_code() {
		return verification_code;
	}

	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
