package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.KhachHang;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KhachHangService {

    public KhachHang saveKhachHang(KhachHang khachHang);

    public List<KhachHang> getAllKhachHang();

    public KhachHang getKhachHangById(int id);

    public KhachHang updateKhachHang(KhachHang khachHang);


}
