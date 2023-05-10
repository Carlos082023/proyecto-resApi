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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity (name="Clientes")
@Table(name="clientes")
public class Clientes implements Serializable{
      private static final long serialVersionUID=1L;
      
           @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column (name="tipo")
    private String tipo;
    @Column (name="documento")
    private int documento;
    @Column (name="telefono")
    private int telefono;
    @Column(name="estado")
    private boolean estado;
}
