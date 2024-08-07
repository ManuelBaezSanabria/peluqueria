/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.service.impl;

import com.peluqueria.peluqueria.dao.ArticuloBlogDao;
import com.peluqueria.peluqueria.domain.ArticuloBlog;
import com.peluqueria.peluqueria.service.ArticuloBlogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMD
 */
@Service
public class ArticuloBlogServiceImpl implements ArticuloBlogService {
    
    @Autowired
    private ArticuloBlogDao articuloblogDao;

    @Override
    public List<ArticuloBlog> getArticuloBlogs() {
        var lista = articuloblogDao.findAll();
        return lista;
    }

    @Override
    public ArticuloBlog getArticuloBlog(ArticuloBlog articuloblog) {
        return articuloblogDao.findById(articuloblog.getIdArticulo()).orElse(null);
    }

    @Override
    public void save(ArticuloBlog articuloblog) {
       articuloblogDao.save(articuloblog);
    }

    @Override
    public void delete(ArticuloBlog articuloblog) {
        articuloblogDao.delete(articuloblog);
    }
    
}
