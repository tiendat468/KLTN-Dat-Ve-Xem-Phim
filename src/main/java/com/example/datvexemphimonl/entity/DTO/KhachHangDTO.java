package com.example.datvexemphimonl.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class KhachHangDTO {
    private int idKhachHang;
    private String tenKhachHang;
    private LocalDate ngaySinh;
    private String sdt;
    private String thongTinThanhToan;

    public KhachHangDTO() {
    }
}
