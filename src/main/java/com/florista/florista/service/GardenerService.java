package com.florista.florista.service;

import com.florista.florista.model.Gardener;
import com.florista.florista.repository.GardenerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardenerService {

    private final GardenerRepository gardenerRepository;

    public GardenerService(GardenerRepository gardenerRepository) {
        this.gardenerRepository = gardenerRepository;
    }

    public Gardener addGardener(Gardener gardener) {
        return gardenerRepository.save(gardener);
    }

    public List<Gardener> getAllGardeners() {
        return gardenerRepository.findAll();
    }

    public Gardener getGardenerById(Long id) {
        return gardenerRepository.findById(id).orElse(null);
    }
}