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

//    @Query("SELECT DISTINCT x.thoi_gian_bat_dau FROM XuatChieu x WHERE x.id_phim=:movieI AND x.ngay_chieu=:startDate")
//    List<String> getXuatChieuByIdPhimAndDate(@Param("movieId") Integer movieId, @Param("startDate") LocalDate startDate);

//    List<XuatChieu> getXuatChieuByIdPhimAndDate(Integer idXuatChieu, LocalDate ngayChieu);
}
