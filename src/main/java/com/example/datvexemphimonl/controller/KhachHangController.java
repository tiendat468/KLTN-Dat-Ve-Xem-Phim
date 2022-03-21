package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.DTO.*;
import com.example.datvexemphimonl.entity.DTO.MainResponse;
import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.service.ChangeDTOService;
import com.example.datvexemphimonl.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/khachHang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private ChangeDTOService changeDTOService;

    @GetMapping
    public List<KhachHangDTO> getAllKhachHang(){
        List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
        List<KhachHangDTO> listDTO = new ArrayList<>();
        khachHangList.forEach(khachHang -> {
            listDTO.add(changeDTOService.changeDTO(khachHang));
        });
        return listDTO;
    }

    @GetMapping("/{id}")
    public KhachHangDTO getKhachHangById(@PathVariable("id") int id) throws Exception{
        KhachHang khachHang = khachHangService.getKhachHangById(id);
        return  changeDTOService.changeDTO(khachHang);
    }


//    @GetMapping("/{id}")
//    public MainResponse<KhachHangDTO> getKhachHangById(@PathVariable("id") int id) throws Exception{
//        return khachHangService.getDetailKhachHang(id);
//    }

    @PostMapping
    public KhachHangDTO saveKhachHang(@RequestBody KhachHang khachHang){
        KhachHang kh = khachHangService.saveKhachHang(khachHang);

        return changeDTOService.changeDTO(kh);
    }

    @PutMapping("/{id}")
    public KhachHangDTO updateKhachHang(@RequestBody KhachHang khachHang){
        KhachHang kh = khachHangService.updateKhachHang(khachHang);

        return changeDTOService.changeDTO(kh);
    }

    @DeleteMapping("/{id}")
    public String deleteKhachHang(@PathVariable("id") int id){
        khachHangService.deleteKhachHang(id);
        return "Success";
    }
}
