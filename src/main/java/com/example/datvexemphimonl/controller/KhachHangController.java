package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khachHang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping
    public List<KhachHang> getAllKhachHang(){
        return khachHangService.getAllKhachHang();
    }

    @GetMapping("/{id}")
    public KhachHang getKhachHangById(@PathVariable("id") int id){
        return khachHangService.getKhachHangById(id);
    }

    @PostMapping
    public KhachHang saveKhachHang(@RequestBody KhachHang khachHang){
        return khachHangService.saveKhachHang(khachHang);
    }

    @PutMapping("/{id}")
    public KhachHang updateKhachHang(@RequestBody KhachHang khachHang){
        return khachHangService.updateKhachHang(khachHang);
    }
}
