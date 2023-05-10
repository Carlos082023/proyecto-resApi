/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Direcciones;
import com.example.integrador.repositories.Idirecciones;
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
public class DireccionesServiceImplement implements DireccionesService {
     @Autowired
        private Idirecciones idirecciones;
        
    @Override
    public List<Direcciones> findAll() {
        return idirecciones.findAll();
    }
    
     @Override
    public List<Direcciones> findCustom() {
        return idirecciones.findAllCustom();
    }
    
    @Override
    public List<Direcciones> findAllCustom() {
          return idirecciones.findAllCustom();
    }

    @Override
    public Optional<Direcciones> findById(long id) {
          return idirecciones.findById(id);
    }

    @Override
    public Direcciones add(Direcciones c) {
          return idirecciones.save(c);
    }

    @Override
    public Direcciones update(Direcciones c) {
        Direcciones objdirecciones =idirecciones.getById(c.getId());
        BeanUtils.copyProperties(c, objdirecciones);
        return idirecciones.save(objdirecciones);
        
    }

    @Override
    public Direcciones delete(Direcciones c) {
        Direcciones objdirecciones =idirecciones.getById(c.getId());   
        objdirecciones.setEstado(false);
        return idirecciones.save(objdirecciones);
        
    }

}

