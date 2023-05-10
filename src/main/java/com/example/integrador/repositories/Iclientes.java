/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.repositories;

import com.example.integrador.entity.Clientes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlo
 */
public interface Iclientes extends JpaRepository<Clientes, Long>{
         @Query("Select c from Clientes c where c.estado = '1'")
    List<Clientes> findAllCustom();
}
