package com.example.datvexemphimonl.entity.DTO;

import com.example.datvexemphimonl.entity.PhongChieu;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class XuatChieuDTO {

    private int idXuatChieu;
    private Date ngayChieu;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private PhimDTO phim;
    private PhongChieuDTO phongChieu;
}
