/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.repositories;

import com.example.integrador.entity.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlo
 */
public interface Iproductos extends JpaRepository<Productos, Long>{
         @Query("Select p from Productos p where p.estado = '1'")
    List<Productos> findAllCustom();
}
