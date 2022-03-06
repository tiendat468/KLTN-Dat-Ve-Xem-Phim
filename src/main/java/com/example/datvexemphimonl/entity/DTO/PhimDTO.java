package com.example.datvexemphimonl.entity.DTO;

import com.example.datvexemphimonl.entity.DienVien;
import com.example.datvexemphimonl.entity.LoaiPhim;
import com.example.datvexemphimonl.entity.XuatChieu;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PhimDTO {
    private int idPhim;
    private String tenPhim;
    private String daoDien;
    private int thoiLuong;
    private int doTuoi;
    private Date ngayCongChieu;
    private String quocGia;
    private String tomTat;
    private String trangThai;
    private LoaiPhimDTO loaiPhim;
    private List<DienVien> dsDienVien;
    private Set<XuatChieu> dsXuatChieu;

    public PhimDTO() {
    }

    public PhimDTO(int idPhim, String tenPhim,String daoDien, int thoiLuong, int doTuoi, Date ngayCongChieu, String quocGia, String tomTat, String trangThai, LoaiPhimDTO loaiPhim, List<DienVien> dsDienVien, Set<XuatChieu> dsXuatChieu) {
        this.idPhim = idPhim;
        this.tenPhim = tenPhim;
        this.daoDien = daoDien;
        this.thoiLuong = thoiLuong;
        this.doTuoi = doTuoi;
        this.ngayCongChieu = ngayCongChieu;
        this.quocGia = quocGia;
        this.tomTat = tomTat;
        this.trangThai = trangThai;
        this.loaiPhim = loaiPhim;
        this.dsDienVien = dsDienVien;
        this.dsXuatChieu = dsXuatChieu;
    }
}
