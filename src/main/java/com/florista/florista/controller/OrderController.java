package com.florista.florista.controller;

import com.florista.florista.model.Order;
import com.florista.florista.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // ✅ Checkout
    @PostMapping("/checkout")
    public Order checkout() {
        return orderService.placeOrder();
    }

    // ✅ Get orders
    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}