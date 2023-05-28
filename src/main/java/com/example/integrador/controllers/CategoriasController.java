/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.controllers;


import com.example.integrador.entity.Categorias;
import com.example.integrador.services.CategoriasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author carlo
 */
@Controller
public class CategoriasController {
    @Autowired
    private CategoriasService service;
    
    @RequestMapping("/Categoria")
    public String viewHomePage(Model model){
        List<Categorias> listCategorias = service.findAll();
        model.addAttribute("listCategorias",listCategorias);
        return("Categoria");
    }
    
     @RequestMapping("/new")
     public String showNewCategoriaForm(Model model){
     Categorias categoria = new Categorias();
     model.addAttribute("categoria",categoria);
     return "New_Categoria";
     }
     
       @RequestMapping(value="/save" , method = RequestMethod.POST)
       public String saveCategoria(@ModelAttribute("Categorias")Categorias categoria){
           service.add(categoria);
           return "redirect:/Categoria";
       
       }
         @RequestMapping("/edit/{id}")
         public ModelAndView showEditCategoriaForm(@PathVariable(name="id")Categorias c){
         ModelAndView mav = new ModelAndView("Edit_categoria");
         Categorias categoria = service.update(c);
         mav.addObject("categoria",categoria);
         return mav;
         }
         
          @RequestMapping("/delete/{id}")
         public String DeleteCategoria(@PathVariable(name="id")Categorias c){

                    //Categorias obj= new Categorias();
                    //obj.setEstado(false);
                    service.delete(c);
                     return "redirect:/Categoria";
                    
            }
    
}
