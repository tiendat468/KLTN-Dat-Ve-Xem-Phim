package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.Phim;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhimService {
    public List<Phim> getAllPhim();
}
