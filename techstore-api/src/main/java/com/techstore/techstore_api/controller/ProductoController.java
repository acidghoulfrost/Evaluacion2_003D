package com.techstore.techstore_api.controller;

import com.techstore.techstore_api.dto.ProductoDTO;
import com.techstore.techstore_api.model.Producto;
import com.techstore.techstore_api.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping
    public Producto crearProducto(
            @RequestBody ProductoDTO dto) {

        return productoService
                .crearProducto(dto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @RequestBody ProductoDTO dto) {

        return productoService
                .actualizarProducto(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(
            @PathVariable Long id) {

        productoService.eliminarProducto(id);
    }
}