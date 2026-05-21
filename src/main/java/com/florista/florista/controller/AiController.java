package com.florista.florista.controller;

import com.florista.florista.service.AiService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/detect")
    public String detect(@RequestParam("file") MultipartFile file) {
        return aiService.detectDisease(file);
    }
}