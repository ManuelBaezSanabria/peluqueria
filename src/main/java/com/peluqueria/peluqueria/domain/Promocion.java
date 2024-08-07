/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="promociones")
public class Promocion implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_promocion")    
    private Long idPromocion;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private Long descuento;
    private String rutaImagen;
    
    @ManyToOne
    @JoinColumn(name="idServicio")
    private Servicio servicio;
    
}
