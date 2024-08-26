/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.controller;

import com.peluqueria.peluqueria.domain.Cita;
import com.peluqueria.peluqueria.service.CitaService;
import com.peluqueria.peluqueria.service.EstilistaService;
import com.peluqueria.peluqueria.service.FirebaseStorageService;
import com.peluqueria.peluqueria.service.ServicioService;
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
@RequestMapping("/cita")
public class CitaController {
    
    @Autowired
    private CitaService citaService;
    @Autowired
    private EstilistaService estilistaService;
    @Autowired
    private ServicioService servicioService;
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/listado-admin")
    public String listadoAdmin(Model model){
        var lista = citaService.getCitas();
        model.addAttribute("citas", lista);
        model.addAttribute("totalCitas", lista.size());
        return "/cita/listado-admin";
    }
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = citaService.getCitas();
        model.addAttribute("citas", lista);
        model.addAttribute("totalCitas", lista.size());
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        var estilistas = estilistaService.getEstilistas();
        model.addAttribute("estilistas", estilistas);
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "/cita/listado";
    }
    
    @PostMapping("/guardar")
        public String guardar(Cita cita){
            citaService.save(cita);
        return "redirect:/cita/listado-admin";
        }
    
    @GetMapping("eliminar/{idCita}")
    public String eliminar(Cita cita){
        citaService.delete(cita);
        return "redirect:/cita/listado-admin";
    }
    
    @GetMapping("modificar/{citaid}")
    public String modificar(Cita cita, Model model){
        cita = citaService.getCita(cita);
        model.addAttribute("cita", cita );
        
        var estilistas = estilistaService.getEstilistas();
        model.addAttribute("estilistas", estilistas);
        
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        
        return "/cita/modifica";
    }
    
}
