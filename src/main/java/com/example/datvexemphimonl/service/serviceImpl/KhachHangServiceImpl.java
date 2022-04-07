package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.DTO.KhachHangDTO;
import com.example.datvexemphimonl.entity.DTO.MainResponse;
import com.example.datvexemphimonl.entity.DTO.exception.ApiException;
import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.repository.KhachHangRepository;
import com.example.datvexemphimonl.service.KhachHangService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.AcceptPendingException;
import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {

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
        return khachHangRepository.findById(id).get();
    }

    @Override
    public KhachHang getKhachHangBySDT(String sdt) {
        return khachHangRepository.findBySdt(sdt);
    }

    @Override
    public KhachHang updateKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public MainResponse<String> deleteKhachHang(int id) {
        khachHangRepository.deleteById(id);
        return new MainResponse<>();
    }

    @Override
    public Boolean checkExistsKhachHangBySdt(String sdt) {
        return khachHangRepository.existsBySdt(sdt);
    }

}
