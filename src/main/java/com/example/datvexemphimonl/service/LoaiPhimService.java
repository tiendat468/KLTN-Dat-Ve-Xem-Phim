package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.LoaiPhim;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoaiPhimService {
    public List<LoaiPhim> getAllLoaiPhim();
}
