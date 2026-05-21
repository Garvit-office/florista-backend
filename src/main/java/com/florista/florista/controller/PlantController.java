package com.florista.florista.controller;

import com.florista.florista.model.Plant;
import com.florista.florista.service.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    // ✅ Add
    @PostMapping("/add")
    public Plant addPlant(@RequestBody Plant plant) {
        return plantService.addPlant(plant);
    }

    // ✅ Get all
    @GetMapping
    public List<Plant> getPlants() {
        return plantService.getAllPlants();
    }

    // ✅ Get by ID
    @GetMapping("/{id}")
    public Plant getById(@PathVariable int id) {
        return plantService.getPlantById(id);
    }

    // ✅ Update
    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Plant plant) {
        return plantService.updatePlant(id, plant);
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return plantService.deletePlant(id);
    }

    // ✅ Search
    @GetMapping("/search")
    public List<Plant> search(@RequestParam String keyword) {
        return plantService.searchPlants(keyword);
    }
}