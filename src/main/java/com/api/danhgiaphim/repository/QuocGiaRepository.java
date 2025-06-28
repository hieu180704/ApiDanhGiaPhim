package com.api.danhgiaphim.repository;

import com.api.danhgiaphim.entity.QuocGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuocGiaRepository extends JpaRepository<QuocGia, Integer>{
    boolean existsByTenQuocGiaIgnoreCase(String tenQuocGia);
}
