package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.entity.XuatChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface XuatChieuRepository extends JpaRepository<XuatChieu, Integer> {
    List<XuatChieu> getXuatChieuByPhim(Phim phim);
}
