package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.DTO.LoaiPhimDTO;
import com.example.datvexemphimonl.entity.LoaiPhim;
import com.example.datvexemphimonl.repository.LoaiPhimRepository;
import com.example.datvexemphimonl.service.LoaiPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiPhimServiceImpl implements LoaiPhimService {

    @Autowired
    private LoaiPhimRepository loaiPhimRepository;

    @Override
    public List<LoaiPhim> getAllLoaiPhim() {
        return loaiPhimRepository.findAll();
    }


}
