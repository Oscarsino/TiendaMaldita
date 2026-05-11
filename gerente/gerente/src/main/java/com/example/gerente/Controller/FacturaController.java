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

import com.example.gerente.Service.FacturaService;
import com.example.gerente.model.Factura;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaServi;

    @GetMapping
    public ResponseEntity<List<Factura>> listar() {
        List<Factura> f = facturaServi.getAllFactura();
        if (f.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(f);
    }

    @GetMapping("/{id_factura}")
    public ResponseEntity<Factura> buscarById(@PathVariable int id_factura) {
        Factura f = facturaServi.getFacturaById(id_factura);
        if (f == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(f);
    }

    @PostMapping
    public ResponseEntity<Factura> guardar(@RequestBody Factura factura) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaServi.createFactura(factura));
    }

    @PutMapping("/{id_factura}")
    public ResponseEntity<Factura> actualizar(@PathVariable int id_factura, @RequestBody Factura factura) {
        Factura updated = facturaServi.updateFactura(id_factura, factura);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_factura}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_factura) {
        try {
            facturaServi.deleteFactura(id_factura);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
