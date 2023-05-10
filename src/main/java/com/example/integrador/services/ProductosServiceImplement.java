/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Productos;
import com.example.integrador.repositories.Iproductos;
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
public class ProductosServiceImplement implements ProductosService {
     @Autowired
        private Iproductos iproductos;
        
    @Override
    public List<Productos> findAll() {
        return iproductos.findAll();
    }
    
     @Override
    public List<Productos> findCustom() {
        return iproductos.findAllCustom();
    }
    
    @Override
    public List<Productos> findAllCustom() {
          return iproductos.findAllCustom();
    }

    @Override
    public Optional<Productos> findById(long id) {
          return iproductos.findById(id);
    }

    @Override
    public Productos add(Productos c) {
          return iproductos.save(c);
    }

    @Override
    public Productos update(Productos c) {
        Productos objproductos =iproductos.getById(c.getId());
        BeanUtils.copyProperties(c, objproductos);
        return iproductos.save(objproductos);
        
    }

    @Override
    public Productos delete(Productos c) {
        Productos objproductos =iproductos.getById(c.getId());   
        objproductos.setEstado(false);
        return iproductos.save(objproductos);
        
    }

}

