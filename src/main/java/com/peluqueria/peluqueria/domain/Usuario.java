package com.peluqueria.peluqueria.domain;

/**
 *
 * @author alex
 */

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;    
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rutaImagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="id_cita", updatable=false)
    private List<Cita> citas;
    
    
    //Para el manejo de roles
    @OneToMany
    @JoinColumn(name="id_usuario", updatable=false)
    private List<Rol> roles;
    
}
