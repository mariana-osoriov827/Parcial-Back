package com.example.parcial.servicios;

import com.example.parcial.dto.BodegaRequest;
import com.example.parcial.dto.BodegaResponse;
import com.example.parcial.dto.ProductoResponse;
import com.example.parcial.model.Bodega;
import com.example.parcial.repositorios.BodegaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegaService {

    private final BodegaRepository bodegaRepository;

    public BodegaResponse crear(BodegaRequest request) {
        Bodega bodega = Bodega.builder()
                .nombre(request.getNombre())
                .ubicacion(request.getUbicacion())
                .build();
        return toResponse(bodegaRepository.save(bodega));
    }

    @Transactional(readOnly = true)
    public List<BodegaResponse> listar() {
        return bodegaRepository.findAll().stream().map(this::toResponse).toList();
    }

    private BodegaResponse toResponse(Bodega bodega) {
        List<ProductoResponse> productos = bodega.getProductos() == null ? List.of()
                : bodega.getProductos().stream()
                .map(p -> ProductoResponse.builder()
                        .id(p.getId())
                        .nombre(p.getNombre())
                        .descripcion(p.getDescripcion())
                        .precio(p.getPrecio())
                        .cantidad(p.getCantidad())
                        .build())
                .toList();

        return BodegaResponse.builder()
                .id(bodega.getId())
                .nombre(bodega.getNombre())
                .ubicacion(bodega.getUbicacion())
                .productos(productos)
                .build();
    }
}
