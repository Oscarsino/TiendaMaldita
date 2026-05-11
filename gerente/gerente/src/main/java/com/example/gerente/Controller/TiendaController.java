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

import com.example.gerente.Service.TiendaService;
import com.example.gerente.model.Tienda;

@RestController
@RequestMapping("/api/tienda")
public class TiendaController {

    @Autowired
    private TiendaService tiendaServi;

    @GetMapping
    public ResponseEntity<List<Tienda>> listar() {
        List<Tienda> t = tiendaServi.getAllTienda();
        if (t.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(t);
    }

    @GetMapping("/{id_tienda}")
    public ResponseEntity<Tienda> buscarById(@PathVariable int id_tienda) {
        Tienda t = tiendaServi.getTiendaById(id_tienda);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(t);
    }

    @PostMapping
    public ResponseEntity<Tienda> guardar(@RequestBody Tienda tienda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tiendaServi.createTienda(tienda));
    }

    @PutMapping("/{id_tienda}")
    public ResponseEntity<Tienda> actualizar(@PathVariable int id_tienda, @RequestBody Tienda tienda) {
        Tienda updated = tiendaServi.updateTienda(id_tienda, tienda);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_tienda}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_tienda) {
        try {
            tiendaServi.deleteTienda(id_tienda);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
