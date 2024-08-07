/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="resenas")
public class Resena implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_resena")    
    private Long idResena;
    private String comentario;
    private int calificacion;
    private Date fecha;    
    
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="idEstiliosta")
    private Estilista estilista;
    
//    @ManyToOne
//    @JoinColumn(name="ServicioID")
//    private Servicio servicio;
    
    
    //El de servicio falta
    
}
