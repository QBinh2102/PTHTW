///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.tqb.repositories.impl;
//
//import com.tqb.hibernatedemov2.HibernateUtils;
//import com.tqb.pojo.User;
//import jakarta.persistence.Query;
//import org.hibernate.Session;
//
///**
// *
// * @author admin
// */
//public class UserRepositoryImpl {
//    public User getUserByUserName(String username){
//        try(Session s = HibernateUtils.getFACTORY().openSession()){
//            Query q = s.createNamedQuery("User,findByUserName", User.class);
//            q.setParameter("username", username);
//            
//            return (User) q.getSingleResult();
//        }
//    }
//}
