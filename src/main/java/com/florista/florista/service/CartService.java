package com.florista.florista.service;

import com.florista.florista.model.CartItem;
import com.florista.florista.model.Plant;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {

    private List<CartItem> cart = new ArrayList<>();
    private final PlantService plantService;

    public CartService(PlantService plantService) {
        this.plantService = plantService;
    }

    // ✅ Add to cart
    public String addToCart(int plantId, int quantity) {

        Plant plant = plantService.getPlantById(plantId);

        if (plant == null) {
            return "Plant not found";
        }

        // check if already exists
        for (CartItem item : cart) {
            if (item.getPlantId() == plantId) {
                item.setQuantity(item.getQuantity() + quantity);
                return "Quantity updated in cart";
            }
        }

        cart.add(new CartItem(
                plant.getId(),
                plant.getName(),
                plant.getPrice(),
                quantity
        ));

        return "Added to cart";
    }

    // ✅ View cart
    public List<CartItem> getCart() {
        return cart;
    }

    // ✅ Clear cart
    public void clearCart() {
        cart.clear();
    }

    // ✅ Calculate total
    public double getTotal() {
        double total = 0;

        for (CartItem item : cart) {
            total += item.getPrice() * item.getQuantity();
        }

        return total;
    }
}