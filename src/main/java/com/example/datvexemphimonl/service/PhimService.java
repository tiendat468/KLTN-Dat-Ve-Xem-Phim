package com.example.datvexemphimonl.service;

import com.example.datvexemphimonl.entity.Phim;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhimService {

    public List<Phim> getAllPhim();

    public Phim savePhim(Phim phim);

    public Phim getPhimById(int id);

    public void deletePhim(int id);

    public Phim updatePhim(Phim phim);
    
    public List<Phim> searchPhim(String search);
}
