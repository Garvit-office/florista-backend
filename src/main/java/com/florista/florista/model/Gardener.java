package com.florista.florista.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gardeners")
public class Gardener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private double pricePerHour;

    public Gardener() {}

    public Gardener(Long id, String name, String location, double pricePerHour) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.pricePerHour = pricePerHour;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPricePerHour() { return pricePerHour; }
    public void setPricePerHour(double pricePerHour) { this.pricePerHour = pricePerHour; }
}