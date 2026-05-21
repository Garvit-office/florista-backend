package com.florista.florista.controller;

import com.florista.florista.model.CartItem;
import com.florista.florista.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // ✅ Add to cart
    @PostMapping("/add")
    public String add(@RequestBody Map<String, Integer> request) {
        return cartService.addToCart(
                request.get("plantId"),
                request.get("quantity")
        );
    }

    // ✅ View cart
    @GetMapping
    public List<CartItem> getCart() {
        return cartService.getCart();
    }

    // ✅ Total
    @GetMapping("/total")
    public double total() {
        return cartService.getTotal();
    }
}