package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.DTO.KhachHangDTO;
import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/khachHang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping
    public List<KhachHangDTO> getAllKhachHang(){
        List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
        List<KhachHangDTO> listDTO = new ArrayList<>();
        khachHangList.forEach(khachHang -> {
            listDTO.add(changeDTO(khachHang));
        });
        return listDTO;
    }

    @GetMapping("/{id}")
    public KhachHangDTO getKhachHangById(@PathVariable("id") int id){
        KhachHang p = khachHangService.getKhachHangById(id);
        return  changeDTO(p);
//        return khachHangService.getKhachHangById(id);
    }

    @PostMapping
    public KhachHangDTO saveKhachHang(@RequestBody KhachHang khachHang){
        KhachHang kh = khachHangService.saveKhachHang(khachHang);

        return changeDTO(kh);
    }

    @PutMapping("/{id}")
    public KhachHangDTO updateKhachHang(@RequestBody KhachHang khachHang){
        KhachHang kh = khachHangService.updateKhachHang(khachHang);

        return changeDTO(kh);
    }

    private KhachHangDTO changeDTO(KhachHang khachHang){
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        khachHangDTO.setIdKhachHang(khachHang.getIdKhachHang());
        khachHangDTO.setTenKhachHang(khachHang.getTenKhachHang());
        khachHangDTO.setMatKhau(khachHang.getMatKhau());
        khachHangDTO.setNgaySinh(khachHang.getNgaySinh());
        khachHangDTO.setSdt(khachHang.getSdt());
        khachHangDTO.setThongTinThanhToan(khachHang.getThongTinThanhToan());
        return khachHangDTO;
    }
}
