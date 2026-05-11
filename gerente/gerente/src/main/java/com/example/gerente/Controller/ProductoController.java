package com.example.gerente.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerente.Service.ProductoService;
import com.example.gerente.model.Producto;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoServi;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> p = productoServi.getAllProducto();
        if (p.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id_producto}")
    public ResponseEntity<Producto> buscarById(@PathVariable int id_producto) {
        Producto p = productoServi.getProductoById(id_producto);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoServi.createProducto(producto));
    }

    @PutMapping("/{id_producto}")
    public ResponseEntity<Producto> actualizar(@PathVariable int id_producto, @RequestBody Producto producto) {
        Producto updated = productoServi.updateProducto(id_producto, producto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_producto}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_producto) {
        try {
            productoServi.deleteProducto(id_producto);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
