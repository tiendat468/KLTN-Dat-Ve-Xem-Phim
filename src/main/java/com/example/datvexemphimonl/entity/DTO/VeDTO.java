package com.example.datvexemphimonl.entity.DTO;

import com.example.datvexemphimonl.entity.LoaiVe;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class VeDTO {

    private int idVe;
    private LocalDate ngayXuatVe;
    private LoaiVe loaiVe;
    private KhachHangDTO khachHang;
    private GheDTO ghe;
    private XuatChieuDTO xuatChieu;

    public VeDTO() {
    }

	public int getIdVe() {
		return idVe;
	}

	public void setIdVe(int idVe) {
		this.idVe = idVe;
	}

	public LocalDate getNgayXuatVe() {
		return ngayXuatVe;
	}

	public void setNgayXuatVe(LocalDate ngayXuatVe) {
		this.ngayXuatVe = ngayXuatVe;
	}

	public LoaiVe getLoaiVe() {
		return loaiVe;
	}

	public void setLoaiVe(LoaiVe loaiVe) {
		this.loaiVe = loaiVe;
	}

	public KhachHangDTO getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangDTO khachHang) {
		this.khachHang = khachHang;
	}

	public GheDTO getGhe() {
		return ghe;
	}

	public void setGhe(GheDTO ghe) {
		this.ghe = ghe;
	}

	public XuatChieuDTO getXuatChieu() {
		return xuatChieu;
	}

	public void setXuatChieu(XuatChieuDTO xuatChieu) {
		this.xuatChieu = xuatChieu;
	}
    
}
