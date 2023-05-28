/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.controllers;

import com.example.integrador.entity.Clientes;
import com.example.integrador.entity.Direcciones;
import com.example.integrador.services.ClientesService;
import com.example.integrador.services.DireccionesService;
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
public class DireccionesController {
      @Autowired
    private DireccionesService service;
      @Autowired
      private ClientesService serviceCliente;
 
    
    @RequestMapping("/Direccion")
    public String viewHomePage(Model model){
        List<Direcciones> listDirecciones = service.findAll();
        model.addAttribute("listDirecciones",listDirecciones);
     
        return("Direccion");
    }
    
     @RequestMapping("/newDireccion")
     public String showNewDireccionForm(Model model){
     Direcciones direccion = new Direcciones();
     model.addAttribute("direccion",direccion);
     List<Clientes> listClientes = serviceCliente.findAllCustom();
     model.addAttribute("listClientes",listClientes);
     return "New_Direccion";
     }
     
       @RequestMapping(value="/saveDireccion" , method = RequestMethod.POST)
       public String saveDireccion(@ModelAttribute("Direcciones")Direcciones direccion){
           service.add(direccion);
           return "redirect:/Direccion";
       
       }
         @RequestMapping("/editDireccion/{id}")
         public ModelAndView showEditDireccionForm(@PathVariable(name="id")Direcciones c){
         ModelAndView mav = new ModelAndView("Edit_Direccion");
         Direcciones direccion = service.update(c);
         mav.addObject("direccion",direccion);
          List<Clientes> listClientes = serviceCliente.findAllCustom();
          mav.addObject("listClientes",listClientes);
     
         return mav;
         }
         
          @RequestMapping("/deleteDireccion/{id}")
         public String DeleteDireccion(@PathVariable(name="id")Direcciones c){

                    //Categorias obj= new Categorias();
                    //obj.setEstado(false);
                    service.delete(c);
                     return "redirect:/Direccion";
                    
            }
}
