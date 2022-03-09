package com.example.datvexemphimonl.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GheDTO {
    private int idGhe;
    private String hangGhe;
    private String cotGhe;
    private PhongChieuDTO phongChieu;

    public GheDTO() {
    }
}
