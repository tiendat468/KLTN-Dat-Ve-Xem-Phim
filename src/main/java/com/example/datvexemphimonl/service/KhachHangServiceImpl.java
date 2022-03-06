package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService{

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public KhachHang saveKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang getKhachHangById(int id) {
        return khachHangRepository.getById(id);
    }

    @Override
    public KhachHang updateKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }
}
