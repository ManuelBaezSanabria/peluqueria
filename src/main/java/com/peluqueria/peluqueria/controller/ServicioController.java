/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.controller;

import com.peluqueria.peluqueria.domain.Servicio;
import com.peluqueria.peluqueria.service.ServicioService;
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
@RequestMapping("/servicio")
public class ServicioController {
    
    @Autowired
    private ServicioService servicioService;
    
    @GetMapping("/listado-admin")
    public String listadoAdmin(Model model){
        var lista = servicioService.getServicios();
        model.addAttribute("servicios", lista);
        model.addAttribute("totalServicios", lista.size());
        return "/servicio/listado-admin";
    }
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = servicioService.getServicios();
        model.addAttribute("servicios", lista);
        model.addAttribute("totalServicios", lista.size());
        return "/servicio/listado";
    }
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
        public String guardar(Servicio servicio, @RequestParam MultipartFile imagenFile){
            if (!imagenFile.isEmpty()){
                //Se sube al storage
                servicioService.save(servicio);
                String rutaImagen=firebaseStorageService.cargaImagen(imagenFile, "servicio", servicio.getIdServicio());
                servicio.setRutaImagen(rutaImagen);
            }
            servicioService.save(servicio);
        return "redirect:/servicio/listado-admin";
        }
    
    @GetMapping("eliminar/{idServicio}")
    public String eliminar(Servicio servicio){
        servicioService.delete(servicio);
        return "redirect:/servicio/listado-admin";
    }
    
    @GetMapping("modificar/{servicioid}")
    public String modificar(Servicio servicio, Model model){
        servicio = servicioService.getServicio(servicio);
        model.addAttribute("servicio", servicio );
        return "/servicio/modifica";
    }
    
}
