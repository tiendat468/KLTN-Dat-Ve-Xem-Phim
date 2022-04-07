package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.DTO.GheDTO;
import com.example.datvexemphimonl.entity.Ghe;
import com.example.datvexemphimonl.service.ChangeDTOService;
import com.example.datvexemphimonl.service.GheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/ghe")
public class GheController {

    @Autowired
    private GheService gheService;

    @Autowired
    private ChangeDTOService changeDTOService;

    @GetMapping("/xuatChieu/{id}")
    public List<GheDTO> getGheByXuatChieu(@PathVariable("id") int id) {
        List<Ghe> ghes = gheService.getGheByXuatChieu(id);
        List<GheDTO> gheDTOS = new ArrayList<>();
        ghes.forEach(ghe -> {
            GheDTO dto = changeDTOService.changeDTO(ghe);
            gheDTOS.add(dto);
        });
        return gheDTOS;
    }
}
