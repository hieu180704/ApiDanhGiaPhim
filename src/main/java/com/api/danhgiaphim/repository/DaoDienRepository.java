package com.api.danhgiaphim.repository;

import com.api.danhgiaphim.entity.DaoDien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoDienRepository extends JpaRepository<DaoDien, Integer> {
}