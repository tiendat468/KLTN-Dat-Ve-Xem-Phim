package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.DTO.XuatChieuDTO;
import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.entity.XuatChieu;
import com.example.datvexemphimonl.service.ChangeDTOService;
import com.example.datvexemphimonl.service.PhimService;
import com.example.datvexemphimonl.service.XuatChieuService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/xuatChieu")
public class XuatChieuController {

    @Autowired
    private XuatChieuService xuatChieuService;

    @Autowired
    private PhimService phimService;

    @Autowired
    private ChangeDTOService changeDTOService;

    @PostMapping
    public XuatChieu saveXuatChieu(@RequestBody XuatChieu xuatChieu) {
        return xuatChieuService.saveXuatChieu(xuatChieu);
    }

    @GetMapping("/{id}")
    public XuatChieuDTO getXuatChieuById(@PathVariable("id") int id) {
        XuatChieu xuatChieu = xuatChieuService.getXuatChieuById(id);

        return changeDTOService.changeDTO(xuatChieu);
    }

    @GetMapping("/phim/{id}")
    public List<XuatChieuDTO> getXuatChieuByPhim(@PathVariable("id") Integer idPhim) {
        Phim phim = phimService.getPhimById(idPhim);
        List<XuatChieu> xuatChieus = xuatChieuService.getXuatChieuByPhim(phim);
        List<XuatChieuDTO> xuatChieuDTOS = new ArrayList<>();
        xuatChieus.forEach(xuatChieu -> {
            System.out.println(xuatChieu.getNgayChieu().toString());
            XuatChieuDTO xuatChieuDTO = changeDTOService.changeDTO(xuatChieu);
            xuatChieuDTOS.add(xuatChieuDTO);
        });
        return xuatChieuDTOS;
    }

    @SneakyThrows
    @GetMapping("/ngayChieu/{id}")
    public List<XuatChieuDTO> getXuatChieuByPhimAndDate(@PathVariable("id") Integer idPhim, Date ngayChieu) throws ParseException {
//        ngayChieu = new Date(2022,03,20);
        System.out.println("Voo dc r nef");
        SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
        ngayChieu = a.parse("2022-03-20");
//        System.out.println(ngayChieu.toString());
        Phim phim = phimService.getPhimById(idPhim);
        List<XuatChieu> xuatChieus = xuatChieuService.getXuatChieuByPhimAndDate(phim, ngayChieu);
        List<XuatChieuDTO> xuatChieuDTOS = new ArrayList<>();
        xuatChieus.forEach(xuatChieu -> {

            System.out.println(xuatChieu.getNgayChieu().toString());
            XuatChieuDTO xuatChieuDTO = changeDTOService.changeDTO(xuatChieu);
            xuatChieuDTOS.add(xuatChieuDTO);
        });
        return xuatChieuDTOS;
    }
}
