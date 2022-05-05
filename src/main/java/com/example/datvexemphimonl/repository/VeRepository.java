package com.example.datvexemphimonl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.datvexemphimonl.entity.Ve;

@Repository
public interface VeRepository extends JpaRepository<Ve, Integer> {
    List<Ve> getVesByXuatChieuIdXuatChieu(int idXuatChieu);
    
    @Query(value = "select * from ve where id_khach_hang = :idKhachHang", nativeQuery = true)
    List<Ve> getVesByKhachHang(@Param("idKhachHang") Integer idKhachHang);
}
