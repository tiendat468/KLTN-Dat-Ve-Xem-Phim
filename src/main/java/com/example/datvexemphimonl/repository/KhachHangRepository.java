package com.example.datvexemphimonl.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.datvexemphimonl.entity.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
	KhachHang findBySdt(String sdt);

	Boolean existsBySdt(String sdt);

	@Query(value = "select * from khach_hang where verification_code = :code", nativeQuery = true)
	KhachHang findByVerification_code(@Param("code") String code);

	@Modifying
	@Transactional
	@Query(value = "UPDATE khach_hang SET enabled = true, verification_code = null WHERE id_khach_hang = :idKhachHang", nativeQuery = true)
	void enabled(@Param("idKhachHang") Integer idKhachHang);
}
