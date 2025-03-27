///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.tqb.repositories.impl;
//
//import com.tqb.hibernatedemov2.HibernateUtils;
//import com.tqb.pojo.OrderDetail;
//import com.tqb.pojo.Product;
//import com.tqb.pojo.SaleOrder;
//import jakarta.persistence.Query;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Join;
//import jakarta.persistence.criteria.JoinType;
//import jakarta.persistence.criteria.Root;
//import java.util.List;
//import org.hibernate.Session;
//
///**
// *
// * @author admin
// */
//public class StatsRepositoryImpl {
//    //Thống kê theo sản phẩm
//    public List<Object[]> statsRevenusByProduct(){
//        try(Session s = HibernateUtils.getFACTORY().openSession()){
//            CriteriaBuilder cb = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);
//            Root root = q.from(OrderDetail.class);
//            Join<OrderDetail,Product> join = root.join("productId", JoinType.RIGHT);
//            
//            q.multiselect(join.get("id"), join.get("name"), 
//                    cb.sum(cb.prod(root.get("quantity"), root.get("unitPrice"))));
//            q.groupBy(join.get("id"));
//            
//            Query query = s.createQuery(q);
//            return query.getResultList();
//        }
//    }
//    
//    //Thống kê theo thời gian
//    public List<Object[]> statsRevenusByTime(String time, int year){
//        try(Session s = HibernateUtils.getFACTORY().openSession()){
//            CriteriaBuilder cb = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);
//            Root root = q.from(OrderDetail.class);
//            Join<OrderDetail,SaleOrder> join = root.join("orderId", JoinType.INNER);
//            
//            q.multiselect(cb.function(time, Integer.class, join.get("createdDate")),
//                    cb.sum(cb.prod(root.get("quantity"), root.get("unitPrice"))));
//            q.where(cb.equal(cb.function("YEAR", Integer.class, join.get("createdDate")),year));
//            q.groupBy(cb.function(time, Integer.class, join.get("createdDate")));
//            
//            Query query = s.createQuery(q);
//            return query.getResultList();
//        }
//    }
//}
