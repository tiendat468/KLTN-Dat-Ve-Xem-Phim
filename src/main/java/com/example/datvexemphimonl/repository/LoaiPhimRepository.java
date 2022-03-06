package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.LoaiPhim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiPhimRepository extends JpaRepository<LoaiPhim,Integer> {
}
