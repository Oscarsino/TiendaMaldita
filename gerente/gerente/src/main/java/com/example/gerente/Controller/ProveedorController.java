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

import com.example.gerente.Service.ProveedorService;
import com.example.gerente.model.Proveedor;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorServi;

    @GetMapping
    public ResponseEntity<List<Proveedor>> listar() {
        List<Proveedor> p = proveedorServi.getAllProveedor();
        if (p.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id_proveedor}")
    public ResponseEntity<Proveedor> buscarById(@PathVariable int id_proveedor) {
        Proveedor p = proveedorServi.getProveedorById(id_proveedor);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Proveedor> guardar(@RequestBody Proveedor proveedor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedorServi.createProveedor(proveedor));
    }

    @PutMapping("/{id_proveedor}")
    public ResponseEntity<Proveedor> actualizar(@PathVariable int id_proveedor, @RequestBody Proveedor proveedor) {
        Proveedor updated = proveedorServi.updateProveedor(id_proveedor, proveedor);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_proveedor}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_proveedor) {
        try {
            proveedorServi.deleteProveedor(id_proveedor);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
