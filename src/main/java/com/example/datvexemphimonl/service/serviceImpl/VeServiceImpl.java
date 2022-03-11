package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.Ve;
import com.example.datvexemphimonl.repository.VeRepository;
import com.example.datvexemphimonl.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeServiceImpl implements VeService {

    @Autowired
    private VeRepository veRepository;

    @Override
    public Ve getVeById(int id) {
//        return veRepository.findById(id).get();
        return veRepository.getById(id);
    }

    @Override
    public Ve saveVe(Ve ve) {
        return veRepository.save(ve);
    }
}
