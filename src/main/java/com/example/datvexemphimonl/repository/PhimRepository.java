package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer> {
}
