/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.controller;

import com.peluqueria.peluqueria.domain.MensajeContacto;
import com.peluqueria.peluqueria.service.MensajeContactoService;
import com.peluqueria.peluqueria.service.FirebaseStorageService;
import com.peluqueria.peluqueria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AMD
 */
@Controller
@RequestMapping("/mensajecontacto")
public class MensajeContactoController {
    
    @Autowired
    private MensajeContactoService mensajecontactoService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/listado-admin")
    public String listadoAdmin(Model model){
        var lista = mensajecontactoService.getMensajeContactos();
        model.addAttribute("mensajecontactos", lista);
        model.addAttribute("totalMensajeContactos", lista.size());
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "/mensajecontacto/listado-admin";
    }
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = mensajecontactoService.getMensajeContactos();
        model.addAttribute("mensajecontactos", lista);
        model.addAttribute("totalMensajeContactos", lista.size());
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "/mensajecontacto/listado";
    }
    
    @PostMapping("/guardar")
        public String guardar(MensajeContacto mensajecontacto){
            mensajecontactoService.save(mensajecontacto);
        return "redirect:/mensajecontacto/listado";
        }
    
    @GetMapping("eliminar/{idMensajeContacto}")
    public String eliminar(MensajeContacto mensajecontacto){
        mensajecontactoService.delete(mensajecontacto);
        return "redirect:/mensajecontacto/listado";
    }
    
    @GetMapping("modificar/{mensajecontactoid}")
    public String modificar(MensajeContacto mensajecontacto, Model model){
        mensajecontacto = mensajecontactoService.getMensajeContacto(mensajecontacto);
        model.addAttribute("mensajecontacto", mensajecontacto );
        return "/mensajecontacto/modifica";
    }
    
}
