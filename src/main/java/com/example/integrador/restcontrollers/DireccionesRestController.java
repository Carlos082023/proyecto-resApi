/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.restcontrollers;

import com.example.integrador.entity.Clientes;
import com.example.integrador.entity.Direcciones;
import com.example.integrador.services.DireccionesService;
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
 */@RestController
@RequestMapping("/Direcciones")
public class DireccionesRestController {
    
       @Autowired
    private DireccionesService service;
    
    @GetMapping
    public List<Direcciones> findAll(){
        Clientes cliente = new Clientes();
        return service.findAll();
    }
    
     @GetMapping("/findAllCustom")
    public List<Direcciones> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Direcciones> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Direcciones add(@RequestBody Direcciones c){
       return service.add(c); 
    }
    
    @PutMapping("/{id}")
    public Direcciones update(@PathVariable Long id,@RequestBody Direcciones c){
        c.setId(id);
       return service.update(c); 
    }
    @DeleteMapping("/{id}")
    public Direcciones delete(@PathVariable Long id){
        Direcciones objdirecciones = new Direcciones();
        objdirecciones.setEstado(false);
       return service.delete(Direcciones.builder().id(id).build()); 
    }
    
}
