/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.services;

import com.example.integrador.entity.Categorias;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public interface CategoriasService {
     // 1 crear metodos de busqueda
    public List<Categorias> findAll();

    public List<Categorias> findCustom();

    public Optional<Categorias> findById(long id);

    public Categorias add(Categorias c);

    public Categorias update(Categorias c);

    public Categorias delete(Categorias c);

    public List<Categorias> findAllCustom();
}
