package com.example.datvexemphimonl.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoaiPhimDTO {

    private int idLoaiPhim;
    private String tenLoaiPhim;

    public LoaiPhimDTO() {
    }

    public LoaiPhimDTO(int idLoaiPhim, String tenLoaiPhim) {
        this.idLoaiPhim = idLoaiPhim;
        this.tenLoaiPhim = tenLoaiPhim;
    }
}
