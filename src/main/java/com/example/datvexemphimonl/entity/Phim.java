package com.example.datvexemphimonl.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Phim")
public class Phim{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phim")
    private int idPhim;

    @Column(name = "ten_phim")
    private String tenPhim;

    @Column(name = "hinh")
    private String hinh;

    @Column(name = "dao_dien")
    private String daoDien;

    @Column(name = "thoi_luong")
    private int thoiLuong;

    @Column(name = "do_tuoi")
    private int doTuoi;

    @Column(name = "ngay_cong_chieu")
    private LocalDate ngayCongChieu;

    @Column(name = "quoc_gia")
    private String quocGia;

    @Column(name = "tom_tat")
    private String tomTat;

    @Column(name = "trang_thai")
    private String trangThai;

   @OneToMany
    private List<DienVien> dsDienVien;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLoaiPhim")
    private LoaiPhim loaiPhim;

    @OneToMany(mappedBy = "phim", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<XuatChieu> dsXuatChieu;

    public Phim() {
    }


}
