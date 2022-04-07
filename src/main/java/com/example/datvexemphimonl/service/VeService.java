package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.Ve;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VeService {

    Ve getVeById(int id);

    Ve saveVe(Ve ve);

    List<Ve> getVeByXuatChieu(int idXuatChieu);

}
