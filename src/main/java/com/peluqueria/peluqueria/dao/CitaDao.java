/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.peluqueria.peluqueria.dao;

import com.peluqueria.peluqueria.domain.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AMD
 */
public interface CitaDao extends JpaRepository<Cita,Long>{
    
}
