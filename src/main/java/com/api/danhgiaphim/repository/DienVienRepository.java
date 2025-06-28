package com.api.danhgiaphim.repository;

import com.api.danhgiaphim.entity.DienVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DienVienRepository extends JpaRepository<DienVien, Integer>{
    boolean existsByTenDienVienIgnoreCase(String tenDienVien);
}
