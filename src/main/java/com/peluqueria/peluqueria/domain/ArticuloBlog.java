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
@Table(name="ArticulosBlog")
public class ArticuloBlog implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_articulo")    
    private Long idArticulo;
    private String titulo;
    private String contenido ;
    private Date fechapublicacion;
    
    @ManyToOne
    @JoinColumn(name="idEstilista")
    private Estilista estilita;
    
}
