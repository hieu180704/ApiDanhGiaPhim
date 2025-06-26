package com.api.danhgiaphim.repository;

import com.api.danhgiaphim.entity.Phim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhimRepository extends JpaRepository<Phim, String> {
    
    
}