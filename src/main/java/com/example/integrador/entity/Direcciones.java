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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity (name="Direcciones")
@Table(name="direcciones")
public class Direcciones implements Serializable{
  
     private static final long serialVersionUID=1L;
     
     @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="comuna")
    private String comuna;
    @Column (name="numero")
    private int numero;
    @Column (name="calle")
    private String calle;
    @Column(name="estado")
    private boolean estado;
    @ManyToOne
    @JoinColumn(name="id_cliente",nullable = false)
    private Clientes clientes;
   
 
}
