package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.XuatChieu;
import org.springframework.stereotype.Service;

@Service
public interface XuatChieuService {

    public XuatChieu saveXuatChieu(XuatChieu xuatChieu);

    public XuatChieu getXuatChieuById(int id);

    public XuatChieu updateXuatChieu(XuatChieu xuatChieu);
}
