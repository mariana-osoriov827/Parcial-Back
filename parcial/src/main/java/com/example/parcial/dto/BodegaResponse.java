package com.example.parcial.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodegaResponse {
    private Long id;
    private String nombre;
    private String ubicacion;
    private List<ProductoResponse> productos;
}
