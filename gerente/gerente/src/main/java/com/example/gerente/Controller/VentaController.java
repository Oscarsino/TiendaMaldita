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

import com.example.gerente.Service.VentaService;
import com.example.gerente.model.Venta;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    @Autowired
    private VentaService ventaServi;

    @GetMapping
    public ResponseEntity<List<Venta>> listar() {
        List<Venta> v = ventaServi.getAllVenta();
        if (v.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(v);
    }

    @GetMapping("/{id_venta}")
    public ResponseEntity<Venta> buscarById(@PathVariable int id_venta) {
        Venta v = ventaServi.getVentaById(id_venta);
        if (v == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(v);
    }

    @PostMapping
    public ResponseEntity<Venta> guardar(@RequestBody Venta venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaServi.createVenta(venta));
    }

    @PutMapping("/{id_venta}")
    public ResponseEntity<Venta> actualizar(@PathVariable int id_venta, @RequestBody Venta venta) {
        Venta updated = ventaServi.updateVenta(id_venta, venta);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_venta}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_venta) {
        try {
            ventaServi.deleteVenta(id_venta);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
