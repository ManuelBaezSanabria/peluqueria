/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.controller;

import com.peluqueria.peluqueria.domain.Usuario;
import com.peluqueria.peluqueria.service.UsuarioService;
import com.peluqueria.peluqueria.service.FirebaseStorageService;
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
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/listado-admin")
    public String listadoAdmin(Model model){
        var lista = usuarioService.getUsuarios();
        model.addAttribute("usuarios", lista);
        model.addAttribute("totalUsuarios", lista.size());
        return "/usuario/listado-admin";
    }
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = usuarioService.getUsuarios();
        model.addAttribute("usuarios", lista);
        model.addAttribute("totalUsuarios", lista.size());
        return "/usuario/listado";
    }
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
        public String guardar(Usuario usuario, @RequestParam MultipartFile imagenFile){
            if (!imagenFile.isEmpty()){
                //Se sube al storage
                usuarioService.save(usuario);
                String rutaImagen=firebaseStorageService.cargaImagen(imagenFile, "usuario", usuario.getIdUsuario());
                usuario.setRutaImagen(rutaImagen);
            }
            usuarioService.save(usuario);
        return "redirect:/usuario/listado-admin";
        }
    
    @GetMapping("eliminar/{idUsuario}")
    public String eliminar(Usuario usuario){
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado-admin";
    }
    
    @GetMapping("modificar/{usuarioid}")
    public String modificar(Usuario usuario, Model model){
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario );
        return "/usuario/modifica";
    }
    
}
