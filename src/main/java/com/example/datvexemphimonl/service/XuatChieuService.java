package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.entity.XuatChieu;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface XuatChieuService {

    XuatChieu saveXuatChieu(XuatChieu xuatChieu);

    XuatChieu getXuatChieuById(int id);

    XuatChieu updateXuatChieu(XuatChieu xuatChieu);

    List<XuatChieu> getXuatChieuByPhim(Phim phim);

    List<XuatChieu> getXuatChieuByPhimAndDate(Phim phim,Date date);
}
