package com.example.datvexemphimonl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.entity.DTO.MainResponse;

@Service
public interface KhachHangService {


    List<KhachHang> getAllKhachHang();

    KhachHang getKhachHangById(int id);

    KhachHang getKhachHangBySDT(String sdt);

    KhachHang saveKhachHang(KhachHang khachHang);

    KhachHang updateKhachHang(KhachHang khachHang);

    MainResponse<String> deleteKhachHang(int id);

    Boolean checkExistsKhachHangBySdt(String sdt);
    
    public boolean verify(String verificationCode);
}
