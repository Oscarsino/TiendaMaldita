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

import com.example.gerente.Service.DetalleVentaService;
import com.example.gerente.model.DetalleVenta;

@RestController
@RequestMapping("/api/detalle")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleServi;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> listar() {
        List<DetalleVenta> d = detalleServi.getAllDetalle();
        if (d.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(d);
    }

    @GetMapping("/{id_detalle}")
    public ResponseEntity<DetalleVenta> buscarById(@PathVariable int id_detalle) {
        DetalleVenta d = detalleServi.getDetalleById(id_detalle);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> guardar(@RequestBody DetalleVenta detalle) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleServi.createDetalle(detalle));
    }

    @PutMapping("/{id_detalle}")
    public ResponseEntity<DetalleVenta> actualizar(@PathVariable int id_detalle, @RequestBody DetalleVenta detalle) {
        DetalleVenta updated = detalleServi.updateDetalle(id_detalle, detalle);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_detalle}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_detalle) {
        try {
            detalleServi.deleteDetalle(id_detalle);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
