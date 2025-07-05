package com.api.danhgiaphim.repository;

import com.api.danhgiaphim.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    boolean existsByPhim_MaPhimAndTaiKhoan_Id(Integer maPhim, Integer maTaiKhoan);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.phim.maPhim = :phimId")
    Double calculateAverageRatingByPhimId(@Param("phimId") Integer phimId);
}
