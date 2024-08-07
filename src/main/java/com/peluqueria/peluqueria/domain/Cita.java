/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="citas")
public class Cita implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_cita")    
    private Long idCita;
    private Date fecha;
    private Timestamp hora;
    
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="idEstilista")
    private Estilista estilista;
    
    @ManyToOne
    @JoinColumn(name="idServicio")
    private Servicio servicio;
    
    //El de servicio falta
    
}
