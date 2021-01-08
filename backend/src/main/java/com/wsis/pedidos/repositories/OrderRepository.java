package com.wsis.pedidos.repositories;

import com.wsis.pedidos.entities.Order;
import com.wsis.pedidos.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
