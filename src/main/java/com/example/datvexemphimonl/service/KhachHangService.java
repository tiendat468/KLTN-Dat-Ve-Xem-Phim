package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.DTO.*;
import com.example.datvexemphimonl.entity.DTO.MainResponse;
import com.example.datvexemphimonl.entity.KhachHang;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface KhachHangService {


    List<KhachHang> getAllKhachHang();

    KhachHang getKhachHangById(int id);

    KhachHang getKhachHangBySDT(String sdt);

    KhachHang saveKhachHang(KhachHang khachHang);

    KhachHang updateKhachHang(KhachHang khachHang);

    MainResponse<String> deleteKhachHang(int id);

    Boolean checkExistsKhachHangBySdt(String sdt);
}
