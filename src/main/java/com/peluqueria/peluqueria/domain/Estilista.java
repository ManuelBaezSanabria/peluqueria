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
@Table(name="estilista")
public class Estilista implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_estilista")    
    private Long idEstilista;
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String especialidad;
    private String rutaImagen; 
    
    @OneToMany
    @JoinColumn(name="id_cita", updatable=false)
    private List<Cita> citas;
}
