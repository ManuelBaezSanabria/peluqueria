/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.service.impl;

import com.peluqueria.peluqueria.dao.ServicioDao;
import com.peluqueria.peluqueria.domain.Servicio;
import com.peluqueria.peluqueria.service.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMD
 */
@Service
public class ServicioServiceImpl implements ServicioService {
    
    @Autowired
    private ServicioDao servicioDao;

    @Override
    public List<Servicio> getServicios() {
        var lista = servicioDao.findAll();
        return lista;
    }

    @Override
    public Servicio getServicio(Servicio servicio) {
        return servicioDao.findById(servicio.getIdServicio()).orElse(null);
    }

    @Override
    public void save(Servicio servicio) {
       servicioDao.save(servicio);
    }

    @Override
    public void delete(Servicio servicio) {
        servicioDao.delete(servicio);
    }
    
}
