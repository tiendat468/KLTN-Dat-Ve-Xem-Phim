package com.example.datvexemphimonl.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.entity.DTO.MainResponse;
import com.example.datvexemphimonl.repository.KhachHangRepository;
import com.example.datvexemphimonl.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {

	@Autowired
	private KhachHangRepository khachHangRepository;

	@Override
	public KhachHang saveKhachHang(KhachHang khachHang) {
		return khachHangRepository.save(khachHang);
	}

	@Override
	public List<KhachHang> getAllKhachHang() {
		return khachHangRepository.findAll();
	}

	@Override
	public KhachHang getKhachHangById(int id) {
		return khachHangRepository.findById(id).get();
	}

	@Override
	public KhachHang getKhachHangBySDT(String sdt) {
		return khachHangRepository.findBySdt(sdt);
	}

	@Override
	public KhachHang updateKhachHang(KhachHang khachHang) {
		return khachHangRepository.save(khachHang);
	}

	@Override
	public MainResponse<String> deleteKhachHang(int id) {
		khachHangRepository.deleteById(id);
		return new MainResponse<>();
	}

	@Override
	public Boolean checkExistsKhachHangBySdt(String sdt) {
		return khachHangRepository.existsBySdt(sdt);
	}

	public boolean verify(String verificationCode) {
		KhachHang khachHang = khachHangRepository.findByVerification_code(verificationCode);

		if (khachHang == null || khachHang.getEnabled()) {
			return false;
		} else {
			khachHang.setVerification_code(null);
			khachHang.setEnabled(true);
			khachHangRepository.enabled(khachHang.getIdKhachHang());

			return true;
		}
	}

}
