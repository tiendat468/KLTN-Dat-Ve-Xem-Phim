package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.DTO.LoaiPhimDTO;
import com.example.datvexemphimonl.entity.LoaiPhim;
import com.example.datvexemphimonl.service.LoaiPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/loaiPhim")
public class LoaiPhimController {

    @Autowired
    private LoaiPhimService loaiPhimService;

    @GetMapping()
    public List<LoaiPhimDTO> getAllLoaiPhim() {
        List<LoaiPhim> loaiPhims = loaiPhimService.getAllLoaiPhim();
        List<LoaiPhimDTO> list = new ArrayList<>();
        loaiPhims.forEach(loaiPhim -> {
            list.add(changeDTO(loaiPhim));
        });

        return list;
    }

    private LoaiPhimDTO changeDTO(LoaiPhim loaiPhim){
        LoaiPhimDTO loaiPhimDTO = new LoaiPhimDTO();
        loaiPhimDTO.setIdLoaiPhim(loaiPhim.getIdLoaiPhim());
        loaiPhimDTO.setTenLoaiPhim(loaiPhim.getTenLoaiPhim());
        return loaiPhimDTO;
    }
}
