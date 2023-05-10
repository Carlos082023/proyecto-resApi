/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.integrador.repositories;

import com.example.integrador.entity.Proveedores;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlo
 */
public interface Iproveedores extends JpaRepository<Proveedores, Long>{
     @Query("Select p from Proveedores p where p.estado = '1'")
    List<Proveedores> findAllCustom();
}
