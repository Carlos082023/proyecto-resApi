/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.restcontrollers;

/**
 *
 * @author carlo
 */

import com.example.integrador.entity.Productos;
import com.example.integrador.services.ProductosService;
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

@RestController
@RequestMapping("/Productos")
public class ProductosRestController {
    
    
       @Autowired
    private ProductosService service;
    
    @GetMapping
    public List<Productos> findAll(){
        return service.findAll();
    }
    
     @GetMapping("/findAllCustom")
    public List<Productos> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Productos> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Productos add(@RequestBody Productos c){
       return service.add(c); 
    }
    
    @PutMapping("/{id}")
    public Productos update(@PathVariable Long id,@RequestBody Productos c){
        c.setId(id);
       return service.update(c); 
    }
    @DeleteMapping("/{id}")
    public Productos delete(@PathVariable Long id){
        Productos objproductos = new Productos();
        objproductos.setEstado(false);
       return service.delete(Productos.builder().id(id).build()); 
    }
    
}
