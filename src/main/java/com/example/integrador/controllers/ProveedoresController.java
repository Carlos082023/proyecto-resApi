/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.controllers;


import com.example.integrador.entity.Categorias;
import com.example.integrador.entity.Proveedores;
import com.example.integrador.services.ProveedoresService;
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
public class ProveedoresController {
    @Autowired
    private ProveedoresService service;
    
    @RequestMapping("/Proveedor")
    public String viewHomePage(Model model){
        List<Proveedores> listProveedores = service.findAll();
        model.addAttribute("listProveedores",listProveedores);
        return("Proveedor");
    }
    
     @RequestMapping("/newProveedor")
     public String showNewProveedorForm(Model model){
     Proveedores proveedor = new Proveedores();
     model.addAttribute("proveedor",proveedor);
     return "New_Proveedor";
     }
     
       @RequestMapping(value="/saveProveedor" , method = RequestMethod.POST)
       public String saveProveedor(@ModelAttribute("Proveedores")Proveedores proveedor){
           service.add(proveedor);
           return "redirect:/Proveedor";
       
       }
         @RequestMapping("/editProveedor/{id}")
         public ModelAndView showEditProveedorForm(@PathVariable(name="id")Proveedores c){
         ModelAndView mav = new ModelAndView("Edit_Proveedor");
         Proveedores proveedor = service.update(c);
         mav.addObject("proveedor",proveedor);
         return mav;
         }
         
          @RequestMapping("/deleteProveedor/{id}")
         public String DeleteProveedor(@PathVariable(name="id")Proveedores c){

                    //Categorias obj= new Categorias();
                    //obj.setEstado(false);
                    service.delete(c);
                     return "redirect:/Proveedor";
                    
            }
    
}
