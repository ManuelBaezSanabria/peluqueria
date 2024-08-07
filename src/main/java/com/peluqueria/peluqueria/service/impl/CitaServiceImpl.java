/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.service.impl;

import com.peluqueria.peluqueria.dao.CitaDao;
import com.peluqueria.peluqueria.domain.Cita;
import com.peluqueria.peluqueria.service.CitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMD
 */
@Service
public class CitaServiceImpl implements CitaService {
    
    @Autowired
    private CitaDao citaDao;

    @Override
    public List<Cita> getCitas() {
        var lista = citaDao.findAll();
        return lista;
    }

    @Override
    public Cita getCita(Cita cita) {
        return citaDao.findById(cita.getIdCita()).orElse(null);
    }

    @Override
    public void save(Cita cita) {
       citaDao.save(cita);
    }

    @Override
    public void delete(Cita cita) {
        citaDao.delete(cita);
    }
    
}
