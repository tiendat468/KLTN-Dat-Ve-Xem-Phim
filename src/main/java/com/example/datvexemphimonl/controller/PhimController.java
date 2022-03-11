package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.DTO.LoaiPhimDTO;
import com.example.datvexemphimonl.entity.DTO.PhimDTO;
import com.example.datvexemphimonl.entity.DienVien;
import com.example.datvexemphimonl.entity.LoaiPhim;
import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.service.ChangeDTOService;
import com.example.datvexemphimonl.service.DienVienService;
import com.example.datvexemphimonl.service.PhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/phim")
public class PhimController {

    @Autowired
    private PhimService phimService;

    @Autowired
    private DienVienService dienVienService;

    @Autowired
    private ChangeDTOService changeDTOService;

    @GetMapping()
    public List<PhimDTO> getAllPhim() {
        List<Phim> phims = phimService.getAllPhim();
        List<PhimDTO> list = new ArrayList<>();
        phims.forEach(phim -> {
            list.add(changeDTOService.changeDTO(phim));
        });

        return list;
    }
    @PostMapping
    public PhimDTO savePhim(@RequestBody Phim phim){
        List<DienVien> dvs = phim.getDsDienVien();
        List<DienVien> dienVienList = new ArrayList<>();
        if(dvs.size() != 0){
            dvs.forEach(dv ->{
                dienVienList.add(dienVienService.addDienVien(dv));
            });
           phim.setDsDienVien(dienVienList);
        }

        Phim p = phimService.savePhim(phim);
        return changeDTOService.changeDTO(p);
    }

    @GetMapping("/{id}")
    public PhimDTO getPhim(@PathVariable("id") int id){
        Phim phim = phimService.getPhimById(id);
        return changeDTOService.changeDTO(phim);
    }

    @PutMapping("/{id}")
    public PhimDTO updatePhim(@RequestBody Phim phim){
        List<DienVien> dvs = phim.getDsDienVien();
        List<DienVien> dienVienList = new ArrayList<>();
        if(dvs.size() != 0){
            dvs.forEach(dv ->{
                dienVienList.add(dienVienService.addDienVien(dv));
            });
            phim.setDsDienVien(dienVienList);
        }


        Phim p = phimService.updatePhim(phim);

        return changeDTOService.changeDTO(p);
    }

}
