package com.api.danhgiaphim.repository;

import com.api.danhgiaphim.entity.DienVienPhim;
import com.api.danhgiaphim.entity.DienVienPhimId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DienVienPhimRepository extends JpaRepository<DienVienPhim, DienVienPhimId> {
    
}