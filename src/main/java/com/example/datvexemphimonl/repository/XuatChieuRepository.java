package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.XuatChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XuatChieuRepository extends JpaRepository<XuatChieu, Integer> {
}
