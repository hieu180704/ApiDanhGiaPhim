package com.api.danhgiaphim.repository;

import com.api.danhgiaphim.entity.TheLoaiPhim;
import com.api.danhgiaphim.entity.TheLoaiPhimId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheLoaiPhimRepository extends JpaRepository<TheLoaiPhim, TheLoaiPhimId> {
    
}