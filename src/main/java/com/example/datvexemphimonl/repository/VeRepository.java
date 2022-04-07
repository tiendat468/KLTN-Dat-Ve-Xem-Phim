package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.Ve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeRepository extends JpaRepository<Ve, Integer> {
    List<Ve> getVesByXuatChieuIdXuatChieu(int idXuatChieu);
}
