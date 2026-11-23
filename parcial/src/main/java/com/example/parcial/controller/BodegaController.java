package com.example.parcial.controller;

import com.example.parcial.dto.BodegaRequest;
import com.example.parcial.dto.BodegaResponse;
import com.example.parcial.servicios.BodegaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodegas")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class BodegaController {

    private final BodegaService bodegaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BodegaResponse crear(@RequestBody BodegaRequest request) {
        return bodegaService.crear(request);
    }

    @GetMapping
    public List<BodegaResponse> listar() {
        return bodegaService.listar();
    }
}
