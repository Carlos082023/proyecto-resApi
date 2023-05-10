/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.restcontrollers;

import com.example.integrador.entity.Categorias;
import com.example.integrador.services.CategoriasService;
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
//1 agregar notacion Controlador REST
@RestController
// 2 para ubicarlo
@RequestMapping("/Categorias")
public class CategoriasRestController {
    
     @Autowired
    private CategoriasService service;
    
    @GetMapping
    public List<Categorias> findAll(){
        return service.findAll();
    }
    
     @GetMapping("/findAllCustom")
    public List<Categorias> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Categorias> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Categorias add(@RequestBody Categorias c){
       return service.add(c); 
    }
    
    @PutMapping("/{id}")
    public Categorias update(@PathVariable Long id,@RequestBody Categorias c){
        c.setId(id);
       return service.update(c); 
    }
    @DeleteMapping("/{id}")
    public Categorias delete(@PathVariable Long id){
        Categorias objcategorias = new Categorias();
        objcategorias.setEstado(false);
       return service.delete(Categorias.builder().id(id).build()); 
    }
    
}
