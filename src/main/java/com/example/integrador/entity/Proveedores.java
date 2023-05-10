/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author carlo
 */

    
@Builder
// 3 metodo contructor con parametros
@AllArgsConstructor
// 4 metodo contructor sin parametros
@NoArgsConstructor
// 5 metodos get y set
@Data
// 6 notación entidad 
@Entity(name="Proveedores")
// 7 notación entidad  tablas
@Table(name="proveedores")

public class Proveedores implements Serializable {
    //8 crear variable serial
    private static final long serialVersionUID=1L;
    //9 insertar atributos a los campos
    //1) declara variables

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="cuit")
    private int cuit;
    @Column(name="direccion")
    private String direccion;
    @Column(name="pagina_web")
    private String pagina_web;
    @Column(name="estado")
    private boolean estado;

 
}

