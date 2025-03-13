/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqb.repositories.impl;

import com.tqb.hibernatedemov2.HibernateUtils;
import com.tqb.pojo.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class CategoryRepositoryImpl {
    public List<Category> getCates(){
        try(Session s = HibernateUtils.getFACTORY().openSession()){
            Query q = s.createQuery("FROM Category", Category.class);
            return q.getResultList();
        }
    }
}
