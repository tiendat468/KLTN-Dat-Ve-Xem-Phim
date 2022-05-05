package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.*;
import com.example.datvexemphimonl.entity.DTO.*;
import com.example.datvexemphimonl.service.ChangeDTOService;
import com.example.datvexemphimonl.service.GheService;
import com.example.datvexemphimonl.service.KhachHangService;
import com.example.datvexemphimonl.service.VeService;
import com.example.datvexemphimonl.service.XuatChieuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
	private GheService gheService;
	
	@Autowired
	private XuatChieuService xuatChieuService;
	
	@Autowired
	private KhachHangService khachHangService;

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
	public ResponseEntity<String> createNewBill(@RequestParam int idLoaiVe, @RequestParam int idGhe, @RequestParam int idKhachHang, @RequestParam int idXuatChieu) {
        try {
        	LoaiVe loaiVe = LoaiVe.THUONG;
        	if(LoaiVe.VIP.getCode() == idLoaiVe) {
        		loaiVe = LoaiVe.VIP;
        	}
        	if(LoaiVe.KHUYENMAI.getCode() == idLoaiVe) {
        		loaiVe = LoaiVe.KHUYENMAI;
        	}
        	Ghe ghe = gheService.getGheById(idGhe);
        	KhachHang khachHang =  khachHangService.getKhachHangById(idKhachHang);
        	XuatChieu xuatChieu = xuatChieuService.getXuatChieuById(idXuatChieu);
        	LocalDate date = LocalDate.now();
        	veService.saveVe(new Ve(date, loaiVe, khachHang, ghe, xuatChieu));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("Bạn đã mua vé xem phim thành công !", HttpStatus.OK);
    }
//	public VeDTO saveVe(@RequestParam Ve ve) {
//		Ve newVe = veService.saveVe(ve);
//
//		return changeDTOService.changeDTO(newVe);
//	}
	@GetMapping("/loaiVe")
	public LoaiVe getLoaive(@RequestParam String date, @RequestParam String time) {
		LocalDate ngayChieu = LocalDate.parse(date);
		if (Integer.parseInt(time.split(":")[0]) >= 22) {
			return LoaiVe.KHUYENMAI;
		} else if ((ngayChieu.getDayOfWeek() == DayOfWeek.SATURDAY || ngayChieu.getDayOfWeek() == DayOfWeek.SUNDAY)) {
			return LoaiVe.VIP;
		} else {
			return LoaiVe.THUONG;
		}
	}
}
