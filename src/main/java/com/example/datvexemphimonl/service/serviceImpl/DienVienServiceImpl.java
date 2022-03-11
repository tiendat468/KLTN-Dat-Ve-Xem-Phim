package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.DienVien;
import com.example.datvexemphimonl.repository.DienVienRepository;
import com.example.datvexemphimonl.service.DienVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DienVienServiceImpl implements DienVienService {

    @Autowired
    private DienVienRepository dienVienRepository;

    @Override
    public DienVien addDienVien(DienVien dienVien) {
        return dienVienRepository.save(dienVien);
    }
}
