/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Clientes;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface ClientesService {
     public List<Clientes> findAll();

    public List<Clientes> findCustom();

    public Optional<Clientes> findById(long id);

    public Clientes add(Clientes c);

    public Clientes update(Clientes c);

    public Clientes delete(Clientes c);

    public List<Clientes> findAllCustom();
}
