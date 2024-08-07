/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.service.impl;

import com.peluqueria.peluqueria.dao.MensajeContactoDao;
import com.peluqueria.peluqueria.domain.MensajeContacto;
import com.peluqueria.peluqueria.service.MensajeContactoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMD
 */
@Service
public class MensajeContactoServiceImpl implements MensajeContactoService {
    
    @Autowired
    private MensajeContactoDao mensajecontactoDao;

    @Override
    public List<MensajeContacto> getMensajeContactos() {
        var lista = mensajecontactoDao.findAll();
        return lista;
    }

    @Override
    public MensajeContacto getMensajeContacto(MensajeContacto mensajecontacto) {
        return mensajecontactoDao.findById(mensajecontacto.getIdMensaje()).orElse(null);
    }

    @Override
    public void save(MensajeContacto mensajecontacto) {
       mensajecontactoDao.save(mensajecontacto);
    }

    @Override
    public void delete(MensajeContacto mensajecontacto) {
        mensajecontactoDao.delete(mensajecontacto);
    }
    
}
