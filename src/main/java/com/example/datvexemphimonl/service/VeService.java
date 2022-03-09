package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.Ve;
import org.springframework.stereotype.Service;

@Service
public interface VeService {

    public Ve getVeById(int id);

    public Ve saveVe(Ve ve);

}
