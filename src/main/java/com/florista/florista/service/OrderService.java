package com.florista.florista.service;

import com.florista.florista.model.Order;
import com.florista.florista.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1;

    private final CartService cartService;

    public OrderService(CartService cartService) {
        this.cartService = cartService;
    }

    // ✅ Checkout
    public Order placeOrder() {

        List<CartItem> cartItems = cartService.getCart();

        if (cartItems.isEmpty()) {
            return null;
        }

        double total = cartService.getTotal();

        Order order = new Order(orderCounter++, new ArrayList<>(cartItems), total);

        orders.add(order);

        cartService.clearCart();

        return order;
    }

    // ✅ Get all orders
    public List<Order> getOrders() {
        return orders;
    }
}