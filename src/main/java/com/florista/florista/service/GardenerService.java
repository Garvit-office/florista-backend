package com.florista.florista.service;

import com.florista.florista.model.Gardener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GardenerService {

    private List<Gardener> gardeners = new ArrayList<>();
    private int idCounter = 1;

    // ✅ Add gardener (admin-like)
    public Gardener addGardener(Gardener gardener) {
        gardener.setId(idCounter++);
        gardeners.add(gardener);
        return gardener;
    }

    // ✅ Get all gardeners
    public List<Gardener> getAllGardeners() {
        return gardeners;
    }

    // ✅ Get by ID
    public Gardener getGardenerById(int id) {
        return gardeners.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
    }
}