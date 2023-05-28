/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.repositories;

import com.example.integrador.entity.Direcciones;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carlo
 */
public interface Idirecciones extends JpaRepository<Direcciones, Long>{
     @Query("Select d from Direcciones d where d.estado = '1'")

    List<Direcciones> findAllCustom();
}
