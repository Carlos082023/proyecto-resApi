/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Proveedores;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface ProveedoresService {
    
     public List<Proveedores> findAll();

    public List<Proveedores> findCustom();

    public Optional<Proveedores> findById(long id);

    public Proveedores add(Proveedores c);

    public Proveedores update(Proveedores c);

    public Proveedores delete(Proveedores c);

    public List<Proveedores> findAllCustom();
}
