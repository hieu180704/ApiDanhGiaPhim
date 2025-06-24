/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.danhgiaphim.repository;
import com.api.danhgiaphim.entity.DaoDien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author ntnfa
 */

@Repository
public interface DaoDienRepository extends JpaRepository<DaoDien, Integer> {
}