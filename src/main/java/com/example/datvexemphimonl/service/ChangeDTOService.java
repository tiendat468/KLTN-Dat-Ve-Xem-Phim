package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.*;
import com.example.datvexemphimonl.entity.DTO.*;
import org.springframework.stereotype.Service;

@Service
public interface ChangeDTOService {

    public KhachHangDTO changeDTO(KhachHang khachHang);

    public LoaiPhimDTO changeDTO(LoaiPhim loaiPhim);

    public PhimDTO changeDTO(Phim phim);

    public VeDTO changeDTO(Ve ve);

    public GheDTO changeDTO(Ghe ghe);

    public PhongChieuDTO changeDTO(PhongChieu phongChieu);

    public XuatChieuDTO changeDTO(XuatChieu xuatChieu);

}
