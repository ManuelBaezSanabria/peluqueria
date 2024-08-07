/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.peluqueria.peluqueria.service;

import com.peluqueria.peluqueria.domain.ArticuloBlog;
import java.util.List;

/**
 *
 * @author AMD
 */
public interface ArticuloBlogService {
        //Se enuncia un método que recupera los registros de la tabla bicicleta dentro de un ArrayList
    public List<ArticuloBlog> getArticuloBlogs();
    
    //Se obtiene un registro de la tabla bicicleta en un objeto bicicleta si el idBicicleta existe sino pasa un null
    public ArticuloBlog getArticuloBlog(ArticuloBlog articuloblog);
    
    //Se crea un nuevo registro en bicicleta si el objeto Bicicleta  NO tiene idBicicleta
    //se actualiza el registro en la tabla bicicleta si el objeto bicicleta tiene un idBicicleta
    public void save(ArticuloBlog articuloblog);
    
    //Se elimina el registro por idBicicleta
    public void delete(ArticuloBlog articuloblog);
}
