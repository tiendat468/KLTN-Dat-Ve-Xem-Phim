package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.DienVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DienVienRepository extends JpaRepository<DienVien, Integer> {
}
