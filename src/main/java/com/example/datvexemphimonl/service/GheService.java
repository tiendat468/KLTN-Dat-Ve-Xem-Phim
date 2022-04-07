package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.Ghe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface GheService {
    List<Ghe> getGheByXuatChieu(int idXuatChieu);
}
