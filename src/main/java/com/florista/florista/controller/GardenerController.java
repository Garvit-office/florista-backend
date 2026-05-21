package com.florista.florista.controller;

import com.florista.florista.model.Gardener;
import com.florista.florista.service.GardenerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gardeners")
public class GardenerController {

    private final GardenerService gardenerService;

    public GardenerController(GardenerService gardenerService) {
        this.gardenerService = gardenerService;
    }

    @PostMapping("/add")
    public Gardener add(@RequestBody Gardener gardener) {
        return gardenerService.addGardener(gardener);
    }

    @GetMapping
    public List<Gardener> getAll() {
        return gardenerService.getAllGardeners();
    }
}