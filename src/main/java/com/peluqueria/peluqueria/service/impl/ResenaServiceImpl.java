/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.service.impl;

import com.peluqueria.peluqueria.dao.ResenaDao;
import com.peluqueria.peluqueria.domain.Resena;
import com.peluqueria.peluqueria.service.ResenaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMD
 */
@Service
public class ResenaServiceImpl implements ResenaService {
    
    @Autowired
    private ResenaDao resenaDao;

    @Override
    public List<Resena> getResenas() {
        var lista = resenaDao.findAll();
        return lista;
    }

    @Override
    public Resena getResena(Resena resena) {
        return resenaDao.findById(resena.getIdResena()).orElse(null);
    }

    @Override
    public void save(Resena resena) {
       resenaDao.save(resena);
    }

    @Override
    public void delete(Resena resena) {
        resenaDao.delete(resena);
    }
    
}
