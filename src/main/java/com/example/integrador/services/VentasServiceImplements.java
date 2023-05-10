/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Ventas;
import com.example.integrador.repositories.Iventas;
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
public class VentasServiceImplements implements VentasService{
    
      @Autowired
        private Iventas iventas;
        
    @Override
    public List<Ventas> findAll() {
        return iventas.findAll();
    }
    
     @Override
    public List<Ventas> findCustom() {
        return iventas.findAllCustom();
    }
    
    @Override
    public List<Ventas> findAllCustom() {
          return iventas.findAllCustom();
    }

    @Override
    public Optional<Ventas> findById(long id) {
          return iventas.findById(id);
    }

    @Override
    public Ventas add(Ventas c) {
          return iventas.save(c);
    }

    @Override
    public Ventas update(Ventas c) {
        Ventas objventas =iventas.getById(c.getId());
        BeanUtils.copyProperties(c, objventas);
        return iventas.save(objventas);
        
    }

    @Override
    public Ventas delete(Ventas c) {
       Ventas objventas =iventas.getById(c.getId());   
        objventas.setEstado(false);
        return iventas.save(objventas);
        
    }
}
