/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Categorias;
import com.example.integrador.repositories.Icategorias;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author carlo
 */
@Service
public class CategoriasServiceImplement implements CategoriasService{

   // 3 agregar anotaciones
        @Autowired
        private Icategorias icategorias;
        
    @Override
    public List<Categorias> findAll() {
        return icategorias.findAll();
    }
    
     @Override
    public List<Categorias> findCustom() {
        return icategorias.findAllCustom();
    }
    
    @Override
    public List<Categorias> findAllCustom() {
          return icategorias.findAllCustom();
    }

    @Override
    public Optional<Categorias> findById(long id) {
          return icategorias.findById(id);
    }

    @Override
    public Categorias add(Categorias c) {
          return icategorias.save(c);
    }

    @Override
    public Categorias update(Categorias c) {
        Categorias objcategorias =icategorias.getById(c.getId());
        BeanUtils.copyProperties(c, objcategorias);
        return icategorias.save(objcategorias);
        
    }

    @Override
    public Categorias delete(Categorias c) {
        Categorias objcategorias =icategorias.getById(c.getId());   
        objcategorias.setEstado(false);
        return icategorias.save(objcategorias);
        
    }

}
