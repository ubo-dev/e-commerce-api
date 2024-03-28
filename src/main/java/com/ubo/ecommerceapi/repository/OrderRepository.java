package com.ubo.ecommerceapi.repository;

import com.ubo.ecommerceapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<UUID, Order>{

    List<Order> findCustomerOrders(UUID customerId);
    Order findByOrderCode(String orderCode);
}
