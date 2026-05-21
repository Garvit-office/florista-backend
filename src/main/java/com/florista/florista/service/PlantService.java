package com.florista.florista.service;

import com.florista.florista.model.Plant;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlantService {

    private List<Plant> plants = new ArrayList<>();
    private int currentId = 1;

    // ✅ Add plant
    public Plant addPlant(Plant plant) {
        plant.setId(currentId++);
        plants.add(plant);
        return plant;
    }

    // ✅ Get all plants
    public List<Plant> getAllPlants() {
        return plants;
    }

    // ✅ Get by ID
    public Plant getPlantById(int id) {
        return plants.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ✅ Update plant
    public String updatePlant(int id, Plant updatedPlant) {

        for (Plant p : plants) {
            if (p.getId() == id) {
                p.setName(updatedPlant.getName());
                p.setType(updatedPlant.getType());
                p.setPrice(updatedPlant.getPrice());
                p.setSeller(updatedPlant.getSeller());
                return "Plant updated successfully";
            }
        }

        return "Plant not found";
    }

    // ✅ Delete plant
    public String deletePlant(int id) {
        boolean removed = plants.removeIf(p -> p.getId() == id);
        return removed ? "Plant deleted" : "Plant not found";
    }

    // ✅ Search by name
    public List<Plant> searchPlants(String keyword) {
        List<Plant> result = new ArrayList<>();

        for (Plant p : plants) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(p);
            }
        }

        return result;
    }
}