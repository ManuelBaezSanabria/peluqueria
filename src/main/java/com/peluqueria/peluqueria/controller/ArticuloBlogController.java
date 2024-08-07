/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peluqueria.peluqueria.controller;

import com.peluqueria.peluqueria.domain.ArticuloBlog;
import com.peluqueria.peluqueria.service.ArticuloBlogService;
import com.peluqueria.peluqueria.service.EstilistaService;
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
@RequestMapping("/articuloblog")
public class ArticuloBlogController {
    
    @Autowired
    private ArticuloBlogService articuloblogService;
    @Autowired
    private EstilistaService estilistaService;
    
    @GetMapping("/listado-admin")
    public String listadoAdmin(Model model){
        var lista = articuloblogService.getArticuloBlogs();
        model.addAttribute("articuloblogs", lista);
        model.addAttribute("totalArticuloBlogs", lista.size());
        return "/articuloblog/listado-admin";
    }
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = articuloblogService.getArticuloBlogs();
        model.addAttribute("articuloblogs", lista);
        model.addAttribute("totalArticuloBlogs", lista.size());
        
        var estilistas = estilistaService.getEstilistas();
        model.addAttribute("estilistas", estilistas);
        
        return "/articuloblog/listado";
    }
    
    @PostMapping("/guardar")
        public String guardar(ArticuloBlog articuloblog){
            articuloblogService.save(articuloblog);
        return "redirect:/articuloblog/listado-admin";
        }
    
    @GetMapping("eliminar/{idArticuloBlog}")
    public String eliminar(ArticuloBlog articuloblog){
        articuloblogService.delete(articuloblog);
        return "redirect:/articuloblog/listado-admin";
    }
    
    @GetMapping("modificar/{articuloblogid}")
    public String modificar(ArticuloBlog articuloblog, Model model){
        articuloblog = articuloblogService.getArticuloBlog(articuloblog);
        model.addAttribute("articuloblog", articuloblog );
        
        var estilistas = estilistaService.getEstilistas();
        model.addAttribute("estilistas", estilistas);
        return "/articuloblog/modifica";
    }
    
}
