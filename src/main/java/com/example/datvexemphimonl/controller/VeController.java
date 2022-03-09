package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.*;
import com.example.datvexemphimonl.entity.DTO.*;
import com.example.datvexemphimonl.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/ve")
public class VeController {

    @Autowired
    private VeService veService;

    @GetMapping("/{id}")
    public VeDTO getVeById(@PathVariable("id")int id){
        Ve ve = veService.getVeById(id);
        return changeDTO(ve);
    }

    private VeDTO changeDTO(Ve ve){
        VeDTO v = new VeDTO();
        v.setIdVe(ve.getIdVe());
        v.setNgayXuatVe(ve.getNgayXuatVe());
        v.setLoaiVe(ve.getLoaiVe());
        KhachHangDTO kh = changeDTO(ve.getKhachHang());
        v.setKhachHang(kh);
        GheDTO ghe = changeDTO(ve.getGhe());
        v.setGhe(ghe);
        XuatChieuDTO xuatChieuDTO = changeDTO(ve.getXuatChieu());
        v.setXuatChieu(xuatChieuDTO);

        return v;
    }

    private KhachHangDTO changeDTO(KhachHang khachHang){
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        khachHangDTO.setIdKhachHang(khachHang.getIdKhachHang());
        khachHangDTO.setTenKhachHang(khachHang.getTenKhachHang());
        khachHangDTO.setMatKhau(khachHang.getMatKhau());
        khachHangDTO.setNgaySinh(khachHang.getNgaySinh());
        khachHangDTO.setSdt(khachHang.getSdt());
        khachHangDTO.setThongTinThanhToan(khachHang.getThongTinThanhToan());
        return khachHangDTO;
    }

    private GheDTO changeDTO(Ghe ghe){
        GheDTO gheDTO = new GheDTO();
        gheDTO.setIdGhe(ghe.getIdGhe());
        gheDTO.setCotGhe(ghe.getCotGhe());
        gheDTO.setHangGhe(ghe.getHangGhe());
        gheDTO.setPhongChieu(changeDTO(ghe.getPhongChieu()));
        return gheDTO;
    }

    private PhongChieuDTO changeDTO(PhongChieu phongChieu){
        PhongChieuDTO phongChieuDTO = new PhongChieuDTO();
        phongChieuDTO.setIdPhong(phongChieu.getIdPhong());
        phongChieuDTO.setSoPhong(phongChieu.getSoPhong());
        return phongChieuDTO;
    }

    private PhimDTO changeDTO(Phim phim){

        Set<DienVien> dvs = new HashSet<>();

        PhimDTO phimDTO = new PhimDTO(phim.getIdPhim(),phim.getTenPhim(),phim.getDaoDien(),phim.getThoiLuong(),phim.getDoTuoi(),phim.getNgayCongChieu(),phim.getQuocGia(),phim.getTomTat(),phim.getTrangThai(),changeDTO(phim.getLoaiPhim()),phim.getDsDienVien());
        return phimDTO;
    }
    private LoaiPhimDTO changeDTO(LoaiPhim loaiPhim){
        LoaiPhimDTO loaiPhimDTO = new LoaiPhimDTO();
        loaiPhimDTO.setIdLoaiPhim(loaiPhim.getIdLoaiPhim());
        loaiPhimDTO.setTenLoaiPhim(loaiPhim.getTenLoaiPhim());
        return loaiPhimDTO;
    }
    private XuatChieuDTO changeDTO(XuatChieu xuatChieu){
        XuatChieuDTO xuatChieuDTO = new XuatChieuDTO();
        xuatChieuDTO.setIdXuatChieu(xuatChieu.getIdXuatChieu());
        xuatChieuDTO.setNgayChieu(xuatChieu.getNgayChieu());
        xuatChieuDTO.setThoiGianBatDau(xuatChieu.getThoiGianBatDau());
        xuatChieuDTO.setThoiGianKetThuc(xuatChieu.getThoiGianKetThuc());
        xuatChieuDTO.setPhongChieu(changeDTO(xuatChieu.getPhongChieu()));
        xuatChieuDTO.setPhim(changeDTO(xuatChieu.getPhim()));
        return xuatChieuDTO;
    }
}
