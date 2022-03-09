package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.XuatChieu;
import com.example.datvexemphimonl.repository.XuatChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XuatChieuServiceImpl implements XuatChieuService{

    @Autowired
    private XuatChieuRepository xuatChieuRepository;

    @Override
    public XuatChieu saveXuatChieu(XuatChieu xuatChieu) {
        return xuatChieuRepository.save(xuatChieu);
    }

    @Override
    public XuatChieu getXuatChieuById(int id) {
        return xuatChieuRepository.findById(id).get();
    }

    @Override
    public XuatChieu updateXuatChieu(XuatChieu xuatChieu) {
        return xuatChieuRepository.save(xuatChieu);
    }
}
