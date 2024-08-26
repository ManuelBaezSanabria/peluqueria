/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name="promociones")
public class Promocion implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_promocion")    
    private Long idPromocion;
    private String nombre;
    private String descripcion;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    private Long descuento;
    private String rutaImagen;
    
    @ManyToOne
    @JoinColumn(name="idServicio")
    private Servicio servicio;
    
}
