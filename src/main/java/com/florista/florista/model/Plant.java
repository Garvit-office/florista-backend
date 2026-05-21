package com.florista.florista.model;

public class Plant {

    private int id;
    private String name;
    private String type;
    private double price;
    private String seller;

    public Plant() {}

    public Plant(int id, String name, String type, double price, String seller) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.seller = seller;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getSeller() { return seller; }
    public void setSeller(String seller) { this.seller = seller; }
}