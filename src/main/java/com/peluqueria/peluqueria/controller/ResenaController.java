/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.controller;

import com.peluqueria.peluqueria.domain.Resena;
import com.peluqueria.peluqueria.service.ResenaService;
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
@RequestMapping("/resena")
public class ResenaController {
    
    @Autowired
    private ResenaService resenaService;
    
    @GetMapping("/listado-admin")
    public String listadoAdmin(Model model){
        var lista = resenaService.getResenas();
        model.addAttribute("resenas", lista);
        model.addAttribute("totalResenas", lista.size());
        return "/resena/listado-admin";
    }
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = resenaService.getResenas();
        model.addAttribute("resenas", lista);
        model.addAttribute("totalResenas", lista.size());
        return "/resena/listado";
    }
    
    @PostMapping("/guardar")
        public String guardar(Resena resena){
            resenaService.save(resena);
        return "redirect:/resena/listado-admin";
        }
    
    @GetMapping("eliminar/{idResena}")
    public String eliminar(Resena resena){
        resenaService.delete(resena);
        return "redirect:/resena/listado-admin";
    }
    
    @GetMapping("modificar/{resenaid}")
    public String modificar(Resena resena, Model model){
        resena = resenaService.getResena(resena);
        model.addAttribute("resena", resena );
        return "/resena/modifica";
    }
    
}
