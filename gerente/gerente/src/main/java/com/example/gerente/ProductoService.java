package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.ProductoRepository;
import com.example.gerente.model.Producto;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepo;

    public List<Producto> getAllProducto() {
        return productoRepo.findAll();
    }

    public Producto getProductoById(int id_producto) {
        Optional<Producto> producto = productoRepo.findByid_producto(id_producto);
        return producto.orElse(null);
    }

    public Producto createProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    public void deleteProducto(int id_producto) {
        productoRepo.deleteById(id_producto);
    }

    public Producto updateProducto(int id_producto, Producto producto) {
        Producto existing = getProductoById(id_producto);
        if (existing != null) {
            existing.setNombre(producto.getNombre());
            existing.setPrecio_venta(producto.getPrecio_venta());
            existing.setId_proveedor(producto.getId_proveedor());
            return productoRepo.save(existing);
        }
        return null;
    }
}
