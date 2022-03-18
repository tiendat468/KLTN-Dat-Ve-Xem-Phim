package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    KhachHang findBySdt(String sdt);
    Boolean existsBySdt(String sdt);
}
