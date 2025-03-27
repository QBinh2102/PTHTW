/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqb.services.impl;

import com.tqb.pojo.Product;
import com.tqb.repositories.ProductRepository;
import com.tqb.services.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository prodRepo;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.prodRepo.getProducts(params);
    }

    @Override
    public Product getProductById(int id) {
        return this.prodRepo.getProductById(id);
    }

    @Override
    public Product createOrUpdate(Product p) {
        return this.prodRepo.createOrUpdate(p);
    }

    @Override
    public void deleteProduct(int id) {
        this.prodRepo.deleteProduct(id);
    }
    
}
