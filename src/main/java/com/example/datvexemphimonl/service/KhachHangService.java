package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.DTO.KhachHangDTO;
import com.example.datvexemphimonl.entity.DTO.MainResponse;
import com.example.datvexemphimonl.entity.KhachHang;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KhachHangService {

    public KhachHang saveKhachHang(KhachHang khachHang);

    public List<KhachHang> getAllKhachHang();

    public KhachHang getKhachHangById(int id);

    public MainResponse<KhachHangDTO> getDetailKhachHang(int id);

    public KhachHang updateKhachHang(KhachHang khachHang);

    public void deleteKhachHang(int id);
}
