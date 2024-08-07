/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="servicio")
public class Servicio implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_servicio")    
    private Long idServicio;
    
    private String nombre;
    private String descripcion;
    private int duracion;
    private int precio;
    private String rutaImagen; 
    
    @OneToMany
    @JoinColumn(name="id_cita", updatable=false)
    private List<Cita> citas;
    
    @OneToMany
    @JoinColumn(name="id_promocion", updatable=false)
    private List<Promocion> promociones;
}
