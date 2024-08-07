/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.service.impl;


import com.peluqueria.peluqueria.dao.UsuarioDao;
import com.peluqueria.peluqueria.domain.Rol;
import com.peluqueria.peluqueria.domain.Usuario;
import com.peluqueria.peluqueria.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AMD
 */
@Service("userDetailsService")
public class UsuarioDetailsServiceImpl 
implements UsuarioDetailsService, UserDetailsService {

    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Se busca el registro en la tabla de usuarios mediante findByUsername
        
        Usuario usuario = usuarioDao.findByUsername(username);
        
        //se válida si se recuperó un usuario de la tabla
        if (usuario==null){
            //No se encontró el usuario
            throw new UsernameNotFoundException(username);
        }
        
        //Si estamos acá... si se encontró el usuario
        
        //Acá va la recuperiación de la foto
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //Se recuperan los roles
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol r: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
        
    }
    
    
    
}
