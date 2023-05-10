/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Direcciones;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface DireccionesService {
     public List<Direcciones> findAll();

    public List<Direcciones> findCustom();

    public Optional<Direcciones> findById(long id);

    public Direcciones add(Direcciones c);

    public Direcciones update(Direcciones c);

    public Direcciones delete(Direcciones c);

    public List<Direcciones> findAllCustom();
}
