package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.Ghe;
import com.example.datvexemphimonl.entity.Ve;
import com.example.datvexemphimonl.entity.XuatChieu;
import com.example.datvexemphimonl.repository.GheRepository;
import com.example.datvexemphimonl.repository.VeRepository;
import com.example.datvexemphimonl.repository.XuatChieuRepository;
import com.example.datvexemphimonl.service.GheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GheServiceImpl implements GheService {

    @Autowired
    private GheRepository gheRepository;

    @Autowired
    private XuatChieuRepository xuatChieuRepository;

    @Autowired
    private VeRepository veRepository;

    @Override
    public List<Ghe> getGheByXuatChieu(int idXuatChieu) {
        Optional<XuatChieu> optionalXuatChieu = xuatChieuRepository.findById(idXuatChieu);

        if (!optionalXuatChieu.isPresent()) {
            return null;
        }
        XuatChieu xuatChieu = optionalXuatChieu.get();
        List<Ghe> list = gheRepository.getGhesByPhongChieu_IdPhong(xuatChieu.getPhongChieu().getIdPhong());
        return list;
    }
}
