package com.example.datvexemphimonl.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.entity.XuatChieu;
import com.example.datvexemphimonl.entity.DTO.XuatChieuDTO;
import com.example.datvexemphimonl.service.ChangeDTOService;
import com.example.datvexemphimonl.service.PhimService;
import com.example.datvexemphimonl.service.XuatChieuService;

import lombok.SneakyThrows;

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

	@GetMapping("/{ngayChieu}/{id}")
	public List<String> getXuatChieuByIdPhimAndDate(@PathVariable("id") Integer idPhim,
			@PathVariable("ngayChieu") String ngayChieu) throws ParseException {
		try {
			Phim phim = phimService.getPhimById(idPhim);
			LocalDate ngayChieu1 = LocalDate.parse(ngayChieu);
			List<XuatChieu> xuatChieus = xuatChieuService.getXuatChieuByPhimAndDate(phim, ngayChieu1);
			List<String> times = new ArrayList<>();
			xuatChieus.forEach(xuatChieu -> {
				times.add(xuatChieu.getThoiGianBatDau());
			});
			times.sort(Comparator.reverseOrder());
			System.out.println(times);
			return times;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/{idPhim}/{date}/{time}")
	public List<XuatChieuDTO> getXuatChieuByIdPhimAndDate(@PathVariable("idPhim") Integer idPhim,
			@PathVariable("date") String date, @PathVariable("time") String time) throws ParseException {
		try {
			Phim phim = phimService.getPhimById(idPhim);
			LocalDate ngayChieu1 = LocalDate.parse(date);
			List<XuatChieu> xuatChieus = xuatChieuService.getXuatChieuByPhimAndNgayGio(idPhim, date, time);
			List<XuatChieuDTO> list = new ArrayList<>();
			for (XuatChieu xuatChieu : xuatChieus) {
				list.add(changeDTOService.changeDTO(xuatChieu));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
