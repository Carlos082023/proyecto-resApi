/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.restcontrollers;

import com.example.integrador.entity.Proveedores;
import com.example.integrador.services.ProveedoresService;
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
@RequestMapping("/Proveedores")
public class ProveedoresRestController {
    
    @Autowired
    private ProveedoresService service;
    
    @GetMapping
    public List<Proveedores> findAll(){
        return service.findAll();
    }
    
     @GetMapping("/findAllCustom")
    public List<Proveedores> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Proveedores> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Proveedores add(@RequestBody Proveedores c){
       return service.add(c); 
    }
    
    @PutMapping("/{id}")
    public Proveedores update(@PathVariable Long id,@RequestBody Proveedores c){
        c.setId(id);
       return service.update(c); 
    }
    @DeleteMapping("/{id}")
    public Proveedores delete(@PathVariable Long id){
        Proveedores objproveedores = new Proveedores();
        objproveedores.setEstado(false);
       return service.delete(Proveedores.builder().id(id).build()); 
    }
    
}
