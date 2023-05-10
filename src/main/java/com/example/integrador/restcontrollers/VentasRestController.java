/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.restcontrollers;

import com.example.integrador.entity.Ventas;
import com.example.integrador.services.VentasService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlo
 */
@RestController
@RequestMapping("/Ventas")
public class VentasRestController {
      @Autowired
    private VentasService service;
    
    @GetMapping
    public List<Ventas> findAll(){
        return service.findAll();
    }
    
     @GetMapping("/findAllCustom")
    public List<Ventas> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Ventas> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Ventas add(@RequestBody Ventas c){
       return service.add(c); 
    }
    
    @PutMapping("/{id}")
    public Ventas update(@PathVariable Long id,@RequestBody Ventas c){
        c.setId(id);
       return service.update(c); 
    }
    @DeleteMapping("/{id}")
    public Ventas delete(@PathVariable Long id){
        Ventas objventas = new Ventas();
        objventas.setEstado(false);
       return service.delete(Ventas.builder().id(id).build()); 
    }
}
