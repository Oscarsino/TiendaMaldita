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

import com.example.gerente.Service.InventarioService;
import com.example.gerente.model.Inventario;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioServi;

    @GetMapping
    public ResponseEntity<List<Inventario>> listar() {
        List<Inventario> i = inventarioServi.getAllInventario();
        if (i.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(i);
    }

    @GetMapping("/{id_inventario}")
    public ResponseEntity<Inventario> buscarById(@PathVariable int id_inventario) {
        Inventario i = inventarioServi.getInventarioById(id_inventario);
        if (i == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(i);
    }

    @PostMapping
    public ResponseEntity<Inventario> guardar(@RequestBody Inventario inventario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventarioServi.createInventario(inventario));
    }

    @PutMapping("/{id_inventario}")
    public ResponseEntity<Inventario> actualizar(@PathVariable int id_inventario, @RequestBody Inventario inventario) {
        Inventario updated = inventarioServi.updateInventario(id_inventario, inventario);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_inventario}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_inventario) {
        try {
            inventarioServi.deleteInventario(id_inventario);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
