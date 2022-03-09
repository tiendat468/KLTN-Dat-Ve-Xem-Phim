package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.XuatChieu;
import com.example.datvexemphimonl.service.XuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/xuatChieu")
public class XuatChieuController {

    @Autowired
    private XuatChieuService xuatChieuService;

    @PostMapping
    public XuatChieu saveXuatChieu(@RequestBody XuatChieu xuatChieu){
        return xuatChieuService.saveXuatChieu(xuatChieu);
    }

    @GetMapping("/{id}")
    public XuatChieu getXuatChieuById(@PathVariable("id") int id){
        return xuatChieuService.getXuatChieuById(id);
    }
}
