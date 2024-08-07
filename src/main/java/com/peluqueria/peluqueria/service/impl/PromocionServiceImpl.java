/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.service.impl;

import com.peluqueria.peluqueria.dao.PromocionDao;
import com.peluqueria.peluqueria.domain.Promocion;
import com.peluqueria.peluqueria.service.PromocionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMD
 */
@Service
public class PromocionServiceImpl implements PromocionService {
        @Autowired
    private PromocionDao promocionDao;

    @Override
    public List<Promocion> getPromociones() {
        var lista = promocionDao.findAll();
        return lista;
    }

    @Override
    public Promocion getPromocion(Promocion promocion) {
        return promocionDao.findById(promocion.getIdPromocion()).orElse(null);
    }

    @Override
    public void save(Promocion promocion) {
       promocionDao.save(promocion);
    }

    @Override
    public void delete(Promocion promocion) {
        promocionDao.delete(promocion);
    }
}
