package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.entity.XuatChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface XuatChieuRepository extends JpaRepository<XuatChieu, Integer> {
	List<XuatChieu> getXuatChieuByPhim(Phim phim);

	@Query(value = "select * from xuat_chieu where id_phim = :idPhim and ngay_chieu = :ngayChieu and thoi_gian_bat_dau = :thoiGian ", nativeQuery = true)
	List<XuatChieu> findByPhimAndNgayGio(@Param("idPhim") Integer idPhim, @Param("ngayChieu") String ngayChieu,
			@Param("thoiGian") String thoiGian);
}
