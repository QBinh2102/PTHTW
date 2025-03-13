/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tqb.hibernatedemov2;

import com.tqb.repositories.impl.CategoryRepositoryImpl;
import com.tqb.repositories.impl.ProductRepositoryImpl;
import com.tqb.repositories.impl.StatsRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemoV2 {

    public static void main(String[] args) {
        CategoryRepositoryImpl cates = new CategoryRepositoryImpl();
        cates.getCates().forEach(c -> System.out.println(c.getName()));
        
        ProductRepositoryImpl prod = new ProductRepositoryImpl();
        
        Map<String,String> params = new HashMap<>();
//        params.put("kw", "galaxy");
//        params.put("fromPrice", "18600000");
//        params.put("cateId", "2");
        params.put("page", "2");
        
        prod.getProducts(params).forEach(p -> System.out.printf("%d - %s: %d\n", p.getId(), p.getName(), p.getPrice()));
        
        StatsRepositoryImpl s2 = new StatsRepositoryImpl();
        s2.statsRevenusByProduct().forEach(o -> System.out.printf("%d - %s: %d\n", o[0], o[1], o[2]));
        System.out.println("============");
        s2.statsRevenusByTime("MONTH", 2020).forEach(o -> System.out.printf("%d - %d\n", o[0], o[1]));
    }
}
