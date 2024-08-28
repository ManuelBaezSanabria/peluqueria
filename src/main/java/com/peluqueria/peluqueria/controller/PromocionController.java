/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.controller;

import com.peluqueria.peluqueria.domain.Promocion;
import com.peluqueria.peluqueria.domain.Servicio;
import com.peluqueria.peluqueria.service.PromocionService;
import com.peluqueria.peluqueria.service.FirebaseStorageService;
import com.peluqueria.peluqueria.service.ServicioService;
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
@RequestMapping("/promocion")
public class PromocionController {
    
    @Autowired
    private PromocionService promocionService;
    
    @Autowired
    private ServicioService servicioService;
    
    @GetMapping("/listado-admin")
    public String listadoAdmin(Model model){
        var lista = promocionService.getPromociones();
        model.addAttribute("promocions", lista);
        model.addAttribute("totalPromocions", lista.size());
        return "/promocion/listado-admin";
    }
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = promocionService.getPromociones();
        model.addAttribute("promociones", lista);
        model.addAttribute("totalPromociones", lista.size());
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        return "/promocion/listado";
    }
    
    @GetMapping("/listado/{idServicio}")
    public String listado(Servicio servicio,Model model){
        var promociones = servicioService.getServicio(servicio).getPromociones();
        model.addAttribute("promociones", promociones);
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        return "/promocion/promos";
    }
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
        public String guardar(Promocion promocion, @RequestParam MultipartFile imagenFile){
            if (!imagenFile.isEmpty()){
                //Se sube al storage
                promocionService.save(promocion);
                String rutaImagen=firebaseStorageService.cargaImagen(imagenFile, "promocion", promocion.getIdPromocion());
                promocion.setRutaImagen(rutaImagen);
            }
            promocionService.save(promocion);
        return "redirect:/promocion/listado-admin";
        }
    
    @GetMapping("eliminar/{idPromocion}")
    public String eliminar(Promocion promocion){
        promocionService.delete(promocion);
        return "redirect:/promocion/listado-admin";
    }
    
    @GetMapping("modificar/{idPromocion}")
    public String modificar(Promocion promocion, Model model){
        promocion = promocionService.getPromocion(promocion);
        model.addAttribute("promocion", promocion );
        return "/promocion/modifica";
    }
    
    @GetMapping("/promos")
    public String promos(Model model){
        var lista = promocionService.getPromociones();
        model.addAttribute("promociones", lista);
        model.addAttribute("totalPromociones", lista.size());
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        return "/promocion/promos";
    }
    
    @GetMapping("/promos/{idServicio}")
    public String promos(Servicio servicio,Model model){
        var promociones = servicioService.getServicio(servicio).getPromociones();
        model.addAttribute("promociones", promociones);
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        return "/promocion/promos";
    }
    
}
