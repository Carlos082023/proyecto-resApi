/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Productos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface ProductosService {
    public List<Productos> findAll();

    public List<Productos> findCustom();

    public Optional<Productos> findById(long id);

    public Productos add(Productos c);

    public Productos update(Productos c);

    public Productos delete(Productos c);

    public List<Productos> findAllCustom();
}
