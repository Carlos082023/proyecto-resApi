/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.controllers;

import com.example.integrador.entity.Categorias;
import com.example.integrador.entity.Productos;
import com.example.integrador.entity.Proveedores;
import com.example.integrador.services.CategoriasService;
import com.example.integrador.services.ProductosService;
import com.example.integrador.services.ProveedoresService;
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
public class ProductosController {

    @Autowired
    private ProductosService service;
    @Autowired
    private ProveedoresService serviceProveedores;
    @Autowired
    private CategoriasService serviceCategorias;

    @RequestMapping("/Producto")
    public String viewHomePage(Model model) {
        List<Productos> listProductos = service.findAll();
        model.addAttribute("listProductos", listProductos);

        return ("Producto");
    }

    @RequestMapping("/newProducto")
    public String showNewProductoForm(Model model) {
        Productos producto = new Productos();
        model.addAttribute("producto", producto);
        List<Proveedores> listProveedores = serviceProveedores.findAllCustom();
        model.addAttribute("listProveedores", listProveedores);
        List<Categorias> listCategorias = serviceCategorias.findAllCustom();
        model.addAttribute("listCategorias", listCategorias);

        return "New_Producto";
    }

    @RequestMapping(value = "/saveProducto", method = RequestMethod.POST)
    public String saveProducto(@ModelAttribute("Productos") Productos producto) {
        service.add(producto);
        return "redirect:/Producto";

    }

    @RequestMapping("/editProducto/{id}")
    public ModelAndView showEditProductosForm(@PathVariable(name = "id") Productos c) {
        ModelAndView mav = new ModelAndView("Edit_Producto");
        Productos producto = service.update(c);
        mav.addObject("producto", producto);
        List<Proveedores> listProveedores = serviceProveedores.findAllCustom();
        mav.addObject("listProveedores", listProveedores);
        List<Categorias> listCategorias = serviceCategorias.findAllCustom();
        mav.addObject("listCategorias", listCategorias);

        return mav;
    }

    @RequestMapping("/deleteProducto/{id}")
    public String DeleteProducto(@PathVariable(name = "id") Productos p) {

        //Categorias obj= new Categorias();
        //obj.setEstado(false);
        service.delete(p);
        return "redirect:/Producto";

    }

}
