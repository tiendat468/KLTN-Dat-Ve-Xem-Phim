package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.DTO.KhachHangDTO;
import com.example.datvexemphimonl.entity.DTO.MainResponse;
import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.repository.KhachHangRepository;
import com.example.datvexemphimonl.service.ChangeDTOService;
import com.example.datvexemphimonl.service.KhachHangService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService{

    private static final Logger LOGGER = LogManager.getLogger(KhachHangService.class);
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private ChangeDTOService changeDTOService;

    @Override
    public KhachHang saveKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang getKhachHangById(int id){
        return khachHangRepository.findById(id).get();
    }

    @Override
    public MainResponse<KhachHangDTO> getDetailKhachHang(int id){
//        KhachHang khachHang = khachHangRepository.findById(id).get();
//        Optional<KhachHang> optionalKhachHang = khachHangRepository.findById(id);
//        System.out.println(id);
//        KhachHangDTO khachHangDTO = changeDTOService.changeDTO(khachHang);
//        return new MainResponse<>(khachHangDTO);
        return null;
    }

    @Override
    public KhachHang updateKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public void deleteKhachHang(int id) {
        khachHangRepository.deleteById(id);
        return;
    }
}
