package com.api.danhgiaphim.repository;

import com.api.danhgiaphim.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai, Integer> {

    boolean existsByTenTheLoaiIgnoreCase(String tenTheLoai);
}
