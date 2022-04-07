package com.example.datvexemphimonl.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class KhachHangDTO {
    private int idKhachHang;
    private String tenKhachHang;
    private Date ngaySinh;
    private String sdt;
    private String thongTinThanhToan;

    public KhachHangDTO() {
    }
}
