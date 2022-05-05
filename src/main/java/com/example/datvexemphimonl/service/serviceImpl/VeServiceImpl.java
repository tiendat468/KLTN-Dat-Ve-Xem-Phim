package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.Ve;
import com.example.datvexemphimonl.entity.XuatChieu;
import com.example.datvexemphimonl.repository.VeRepository;
import com.example.datvexemphimonl.repository.XuatChieuRepository;
import com.example.datvexemphimonl.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeServiceImpl implements VeService {

    @Autowired
    private VeRepository veRepository;

    @Autowired
    private XuatChieuRepository xuatChieuRepository;

    @Override
    public Ve getVeById(int id) {
        return veRepository.getById(id);
    }

    @Override
    public Ve saveVe(Ve ve) {
        return veRepository.save(ve);
    }

    @Override
    public List<Ve> getVeByXuatChieu(int idXuatChieu) {
        Optional<XuatChieu> optionalXuatChieu = xuatChieuRepository.findById(idXuatChieu);

        if (!optionalXuatChieu.isPresent()){
            return null;
        }
        XuatChieu xuatChieu = optionalXuatChieu.get();
        return veRepository.getVesByXuatChieuIdXuatChieu(xuatChieu.getIdXuatChieu());
    }
    
    @Override
	public List<Ve> getVeByKhachHang(int idKhachHang) {
		return veRepository.getVesByKhachHang(idKhachHang);
	}
}
