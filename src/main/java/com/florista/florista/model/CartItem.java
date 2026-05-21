package com.florista.florista.model;

public class CartItem {

    private int plantId;
    private String name;
    private double price;
    private int quantity;

    public CartItem() {}

    public CartItem(int plantId, String name, double price, int quantity) {
        this.plantId = plantId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getPlantId() { return plantId; }
    public void setPlantId(int plantId) { this.plantId = plantId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}