package com.example.servingwebcontent.Repositories;

import com.example.servingwebcontent.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}