package com.example.datvexemphimonl.entity.DTO;

import com.example.datvexemphimonl.entity.PhongChieu;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class XuatChieuDTO {

    private int idXuatChieu;
    private LocalDate ngayChieu;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private PhimDTO phim;
    private PhongChieuDTO phongChieu;
}
