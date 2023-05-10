/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Proveedores;
import com.example.integrador.repositories.Iproveedores;
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
public class ProveedoresServiceImplement implements ProveedoresService {
    
      @Autowired
        private Iproveedores iproveedores;
        
    @Override
    public List<Proveedores> findAll() {
        return iproveedores.findAll();
    }
    
     @Override
    public List<Proveedores> findCustom() {
        return iproveedores.findAllCustom();
    }
    
    @Override
    public List<Proveedores> findAllCustom() {
          return iproveedores.findAllCustom();
    }

    @Override
    public Optional<Proveedores> findById(long id) {
          return iproveedores.findById(id);
    }

    @Override
    public Proveedores add(Proveedores c) {
          return iproveedores.save(c);
    }

    @Override
    public Proveedores update(Proveedores c) {
        Proveedores objproveedores =iproveedores.getById(c.getId());
        BeanUtils.copyProperties(c, objproveedores);
        return iproveedores.save(objproveedores);
        
    }

    @Override
    public Proveedores delete(Proveedores c) {
        Proveedores objproveedores =iproveedores.getById(c.getId());   
        objproveedores.setEstado(false);
        return iproveedores.save(objproveedores);
        
    }
}
