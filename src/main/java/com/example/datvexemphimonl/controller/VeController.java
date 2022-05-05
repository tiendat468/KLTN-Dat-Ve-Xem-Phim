package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.*;
import com.example.datvexemphimonl.entity.DTO.*;
import com.example.datvexemphimonl.service.ChangeDTOService;
import com.example.datvexemphimonl.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/ve")
public class VeController {

    @Autowired
    private VeService veService;

    @Autowired
    private ChangeDTOService changeDTOService;

    @GetMapping("/{id}")
    public VeDTO getVeById(@PathVariable("id") int id) {
        Ve ve = veService.getVeById(id);
        return changeDTOService.changeDTO(ve);
    }

    @GetMapping("/xuatChieu")
    public List<VeDTO> getVeByXuatChieu(@RequestParam int idXuatChieu) {
        List<Ve> ves = veService.getVeByXuatChieu(idXuatChieu);
        List<VeDTO> veDTOS = new ArrayList<>();
        ves.forEach(ve -> {
            veDTOS.add(changeDTOService.changeDTO(ve));
        });
        return veDTOS;
    }
    
    @PostMapping
    public VeDTO saveVe(@RequestParam Ve ve) {
    	 Ve newVe = veService.saveVe(ve);

         return changeDTOService.changeDTO(newVe);
    }
}
