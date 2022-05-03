package com.example.datvexemphimonl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.datvexemphimonl.entity.Phim;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer> {
	@Query(value = "select * from phim where ten_phim like :search", nativeQuery = true)
	List<Phim> findPhimBySearch(@Param("search") String search);
}
