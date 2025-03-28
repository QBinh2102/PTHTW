/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqb.controllers;

import com.tqb.pojo.Product;
import com.tqb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author GIGA
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService prodService;
    
    @GetMapping("/products")
    public String createView(Model model){
        model.addAttribute("product", new Product());
        return "products";
    }
    
    @PostMapping("/add")
    public String add(@ModelAttribute(value = "product") Product p){
        this.prodService.createOrUpdate(p);
        return "redirect:/";
    }
}
