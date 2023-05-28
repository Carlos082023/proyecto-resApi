/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.controllers;


import com.example.integrador.entity.Clientes;
import com.example.integrador.entity.Productos;
import com.example.integrador.entity.Ventas;
import com.example.integrador.services.ClientesService;
import com.example.integrador.services.ProductosService;
import com.example.integrador.services.VentasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author carlo
 */
@Controller
public class VentasController {

    @Autowired
    private VentasService service;
    @Autowired
    private ProductosService serviceProductos;
    @Autowired
    private ClientesService serviceClientes;

    @RequestMapping("/Venta")
    public String viewHomePage(Model model) {
        List<Ventas> listVentas = service.findAll();
        model.addAttribute("listVentas", listVentas);

        return ("Venta");
    }

    @RequestMapping("/newVenta")
    public String showNewVentaForm(Model model) {
        Ventas venta = new Ventas();
        model.addAttribute("venta", venta);
        List<Productos> listProductos = serviceProductos.findAllCustom();
        model.addAttribute("listProductos", listProductos);
        List<Clientes> listClientes = serviceClientes.findAllCustom();
        model.addAttribute("listClientes", listClientes);

        return "New_Venta";
    }

    @RequestMapping(value = "/saveVenta", method = RequestMethod.POST)
    public String saveVenta(@ModelAttribute("Ventas") Ventas venta) {
        service.add(venta);
        return "redirect:/Venta";

    }

    @RequestMapping("/editventa/{id}")
    public ModelAndView showEditVentaForm(@PathVariable(name = "id") Ventas v) {
        ModelAndView mav = new ModelAndView("Edit_Venta");
        Ventas venta = service.update(v);
        mav.addObject("venta", venta);
        List<Productos> listProductos = serviceProductos.findAllCustom();
        mav.addObject("listProductos", listProductos);
        List<Clientes> listClientes = serviceClientes.findAllCustom();
        mav.addObject("listClientes", listClientes);

        return mav;
    }

    @RequestMapping("/deleteventa/{id}")
    public String DeleteVenta(@PathVariable(name = "id") Ventas v) {

        //Categorias obj= new Categorias();
        //obj.setEstado(false);
        service.delete(v);
        return "redirect:/Venta";

    }

}
