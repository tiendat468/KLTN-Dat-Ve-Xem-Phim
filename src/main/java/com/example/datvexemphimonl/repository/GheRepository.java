package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.Ghe;
import com.example.datvexemphimonl.entity.PhongChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GheRepository extends JpaRepository<Ghe, Integer> {

    List<Ghe> getGhesByPhongChieu_IdPhong(int idPhongChieu);
}
