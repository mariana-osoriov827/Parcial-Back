package com.example.parcial.config;

import com.example.parcial.model.Bodega;
import com.example.parcial.model.Producto;
import com.example.parcial.repositorios.BodegaRepository;
import com.example.parcial.repositorios.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

        private final BodegaRepository bodegaRepository;
        private final ProductoRepository productoRepository;

        @Override
        public void run(String... args) {
                Bodega norte = bodegaRepository.save(Bodega.builder()
                        .nombre("Bodega Norte")
                        .ubicacion("Zona Norte")
                        .build());

                Bodega sur = bodegaRepository.save(Bodega.builder()
                        .nombre("Bodega Sur")
                        .ubicacion("Zona Sur")
                        .build());

                productoRepository.save(Producto.builder()
                        .nombre("Computador portátil")
                        .descripcion("Laptop para trabajo")
                        .precio(2500000.0)
                        .cantidad(15)
                        .bodega(norte)
                        .build());

                productoRepository.save(Producto.builder()
                        .nombre("Monitor")
                        .descripcion("Monitor de 24 pulgadas")
                        .precio(750000.0)
                        .cantidad(20)
                        .bodega(norte)
                        .build());

                productoRepository.save(Producto.builder()
                        .nombre("Impresora")
                        .descripcion("Impresora láser")
                        .precio(1200000.0)
                        .cantidad(8)
                        .bodega(sur)
                        .build());
        }
}
