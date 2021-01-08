package com.wsis.pedidos.services;

import com.wsis.pedidos.dto.OrderDTO;
import com.wsis.pedidos.dto.ProductDTO;
import com.wsis.pedidos.entities.OderStatus;
import com.wsis.pedidos.entities.Order;
import com.wsis.pedidos.entities.Product;
import com.wsis.pedidos.repositories.OrderRepository;
import com.wsis.pedidos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findPendigOrders();
        return list.stream()
                .map(o -> new OrderDTO(o))
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO order) {
        Order orderEntity = new Order(
                null,
                order.getAddress(),
                order.getLatitude(),
                order.getLongitude(),
                Instant.now(),
                OderStatus.PENDING);

        for (ProductDTO p: order.getProducts()) {
            Product product = productRepository.getOne(p.getId());
            orderEntity.getProducts().add(product);
        }

        orderEntity = repository.save(orderEntity);
        return new OrderDTO(orderEntity);
    }

    @Transactional
    public OrderDTO setDelivered(Long id) {
        Order order = repository.getOne(id);
        order.setStatus(OderStatus.DELIVERED);

        order = repository.save(order);
        return new OrderDTO(order);
    }

}
