/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.repositories;

import com.example.integrador.entity.Ventas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlo
 */
public interface Iventas extends JpaRepository<Ventas, Long>{
      @Query("Select v from Ventas v where v.estado = '1'")
    List<Ventas> findAllCustom();   
}
