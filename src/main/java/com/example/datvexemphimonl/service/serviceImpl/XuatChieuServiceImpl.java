package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.entity.XuatChieu;
import com.example.datvexemphimonl.repository.XuatChieuRepository;
import com.example.datvexemphimonl.service.XuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class XuatChieuServiceImpl implements XuatChieuService {

    @Autowired
    private XuatChieuRepository xuatChieuRepository;

    @Override
    public XuatChieu saveXuatChieu(XuatChieu xuatChieu) {
        return xuatChieuRepository.save(xuatChieu);
    }

    @Override
    public XuatChieu getXuatChieuById(int id) {
        return xuatChieuRepository.findById(id).get();
    }

    @Override
    public XuatChieu updateXuatChieu(XuatChieu xuatChieu) {
        return xuatChieuRepository.save(xuatChieu);
    }

    @Override
    public List<XuatChieu> getXuatChieuByPhim(Phim phim) {
        return xuatChieuRepository.getXuatChieuByPhim(phim);
    }

    @Override
    public List<XuatChieu> getXuatChieuByPhimAndDate(Phim phim, LocalDate date) {
        List<XuatChieu> xuatChieus = xuatChieuRepository.getXuatChieuByPhim(phim);
        List<XuatChieu> result = new ArrayList<>();
        xuatChieus.forEach(xuatChieu -> {
            if (xuatChieu.getNgayChieu().compareTo(date) == 0) {
                result.add(xuatChieu);
            }
        });
        return result;
    }

//    @Override
//    public List<XuatChieu> getXuatChieuByIdPhimAndDate(Integer movieId, LocalDate date) {
//        return xuatChieuRepository.getXuatChieuByIdPhimAndDate(movieId,date);
//    }

}
