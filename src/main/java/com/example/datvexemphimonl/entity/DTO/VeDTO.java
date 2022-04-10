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
}
