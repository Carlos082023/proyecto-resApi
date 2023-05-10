/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Ventas;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface VentasService {
     public List<Ventas> findAll();

    public List<Ventas> findCustom();

    public Optional<Ventas> findById(long id);

    public Ventas add(Ventas c);

    public Ventas update(Ventas c);

    public Ventas delete(Ventas c);

    public List<Ventas> findAllCustom();
}
