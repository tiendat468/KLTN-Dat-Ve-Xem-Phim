package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.DTO.LoaiPhimDTO;
import com.example.datvexemphimonl.entity.DTO.PhimDTO;
import com.example.datvexemphimonl.entity.DienVien;
import com.example.datvexemphimonl.entity.LoaiPhim;
import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.service.PhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/phim")
public class PhimController {
    @Autowired
    private PhimService phimService;

    @GetMapping()
    public List<PhimDTO> getAllPhim() {
        List<Phim> phims = phimService.getAllPhim();
        List<PhimDTO> list = new ArrayList<>();
        phims.forEach(phim -> {
            list.add(changeDTO(phim));
        });

        return list;
    }

    private PhimDTO changeDTO(Phim phim){

        Set<DienVien> dvs = new HashSet<>();

        PhimDTO phimDTO = new PhimDTO(phim.getIdPhim(),phim.getTenPhim(),phim.getThoiLuong(),phim.getDoTuoi(),phim.getNgayCongChieu(),phim.getQuocGia(),phim.getTomTat(),phim.getTrangThai(),changeDTO(phim.getLoaiPhim()),phim.getDsDienVien(),phim.getDsXuatChieu());
        return phimDTO;
    }
    private LoaiPhimDTO changeDTO(LoaiPhim loaiPhim){
        LoaiPhimDTO loaiPhimDTO = new LoaiPhimDTO();
        loaiPhimDTO.setIdLoaiPhim(loaiPhim.getIdLoaiPhim());
        loaiPhimDTO.setTenLoaiPhim(loaiPhim.getTenLoaiPhim());
        return loaiPhimDTO;
    }
}
