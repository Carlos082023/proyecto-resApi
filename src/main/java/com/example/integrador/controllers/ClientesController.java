/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.controllers;

import com.example.integrador.entity.Clientes;
import com.example.integrador.services.ClientesService;
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
public class ClientesController {
    @Autowired
    private ClientesService service;
    
     @RequestMapping("/Cliente")
    public String viewHomePage(Model model){
        List<Clientes> listCliente = service.findAll();
        model.addAttribute("listCliente",listCliente);
        return("Cliente");
    }
    @RequestMapping("/newCliente")
     public String showNewClienteForm(Model model){
     Clientes cliente = new Clientes();
     model.addAttribute("cliente",cliente);
     return "New_Cliente";
     }
     
      @RequestMapping(value="/saveCliente", method = RequestMethod.POST)
       public String saveCliente(@ModelAttribute("Clientes")Clientes cliente){
           service.add(cliente);
           return "redirect:/Cliente";
       
       }
       
        @RequestMapping("/editCliente/{id}")
         public ModelAndView showEditClienteForm(@PathVariable(name="id")Clientes c){
         ModelAndView mav = new ModelAndView("Edit_Cliente");
         Clientes cliente = service.update(c);
         mav.addObject("cliente",cliente);
         return mav;
         }
         
         @RequestMapping("/deleteCliente/{id}")
          public String DeleteCliente(@PathVariable(name="id")Clientes c){
                   
                    service.delete(c);
                     return "redirect:/Cliente";
                    
            }
    
    
}
