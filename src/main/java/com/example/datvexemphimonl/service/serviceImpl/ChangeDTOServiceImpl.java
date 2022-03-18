package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.*;
import com.example.datvexemphimonl.entity.DTO.*;
import com.example.datvexemphimonl.service.ChangeDTOService;
import org.springframework.stereotype.Service;

@Service
public class ChangeDTOServiceImpl implements  ChangeDTOService{

    @Override
    public KhachHangDTO changeDTO(KhachHang khachHang) {
        KhachHangDTO khachHangDTO = new KhachHangDTO();

        khachHangDTO.setIdKhachHang(khachHang.getIdKhachHang());
        khachHangDTO.setTenKhachHang(khachHang.getTenKhachHang());
        khachHangDTO.setNgaySinh(khachHang.getNgaySinh());
        khachHangDTO.setSdt(khachHang.getSdt());
        khachHangDTO.setThongTinThanhToan(khachHang.getThongTinThanhToan());

        return khachHangDTO;
    }

    @Override
    public LoaiPhimDTO changeDTO(LoaiPhim loaiPhim) {
        LoaiPhimDTO loaiPhimDTO = new LoaiPhimDTO();

        loaiPhimDTO.setIdLoaiPhim(loaiPhim.getIdLoaiPhim());
        loaiPhimDTO.setTenLoaiPhim(loaiPhim.getTenLoaiPhim());

        return loaiPhimDTO;
    }

    @Override
    public PhimDTO changeDTO(Phim phim) {
        PhimDTO phimDTO = new PhimDTO();

        phimDTO.setIdPhim(phim.getIdPhim());
        phimDTO.setTenPhim(phim.getTenPhim());
        phimDTO.setHinh(phim.getHinh());
        phimDTO.setDaoDien(phim.getDaoDien());
        phimDTO.setThoiLuong(phim.getThoiLuong());
        phimDTO.setDoTuoi(phim.getDoTuoi());
        phimDTO.setNgayCongChieu(phim.getNgayCongChieu());
        phimDTO.setQuocGia(phim.getQuocGia());
        phimDTO.setTomTat(phim.getTomTat());
        phimDTO.setTrangThai(phim.getTrangThai());

        LoaiPhimDTO loaiPhimDTO = changeDTO(phim.getLoaiPhim());
        phimDTO.setLoaiPhim(loaiPhimDTO);

        phimDTO.setDsDienVien(phim.getDsDienVien());

        return phimDTO;

    }

    @Override
    public VeDTO changeDTO(Ve ve) {
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

    @Override
    public GheDTO changeDTO(Ghe ghe) {
        GheDTO gheDTO = new GheDTO();

        gheDTO.setIdGhe(ghe.getIdGhe());
        gheDTO.setCotGhe(ghe.getCotGhe());
        gheDTO.setHangGhe(ghe.getHangGhe());
        gheDTO.setPhongChieu(changeDTO(ghe.getPhongChieu()));

        return gheDTO;
    }

    @Override
    public PhongChieuDTO changeDTO(PhongChieu phongChieu) {
        PhongChieuDTO phongChieuDTO = new PhongChieuDTO();

        phongChieuDTO.setIdPhong(phongChieu.getIdPhong());
        phongChieuDTO.setSoPhong(phongChieu.getSoPhong());

        return phongChieuDTO;
    }

    @Override
    public XuatChieuDTO changeDTO(XuatChieu xuatChieu) {
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
