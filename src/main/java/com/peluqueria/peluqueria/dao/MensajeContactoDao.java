/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.peluqueria.peluqueria.dao;

import com.peluqueria.peluqueria.domain.Cita;
import com.peluqueria.peluqueria.domain.MensajeContacto;
import com.peluqueria.peluqueria.domain.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AMD
 */
public interface MensajeContactoDao extends JpaRepository<MensajeContacto,Long>{
    
}
