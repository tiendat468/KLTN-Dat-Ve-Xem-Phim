package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.repository.PhimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhimServiceImpl implements PhimService{

    @Autowired
    private PhimRepository phimRepository;

    @Override
    public List<Phim> getAllPhim() {
        return phimRepository.findAll();
    }
}
