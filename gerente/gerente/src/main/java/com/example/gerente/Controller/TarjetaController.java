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

import com.example.gerente.Service.TarjetaService;
import com.example.gerente.model.Tarjeta;

@RestController
@RequestMapping("/api/tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaServi;

    @GetMapping
    public ResponseEntity<List<Tarjeta>> listar() {
        List<Tarjeta> t = tarjetaServi.getAllTarjeta();
        if (t.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(t);
    }

    @GetMapping("/{id_tarjeta}")
    public ResponseEntity<Tarjeta> buscarById(@PathVariable int id_tarjeta) {
        Tarjeta t = tarjetaServi.getTarjetaById(id_tarjeta);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(t);
    }

    @PostMapping
    public ResponseEntity<Tarjeta> guardar(@RequestBody Tarjeta tarjeta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarjetaServi.createTarjeta(tarjeta));
    }

    @PutMapping("/{id_tarjeta}")
    public ResponseEntity<Tarjeta> actualizar(@PathVariable int id_tarjeta, @RequestBody Tarjeta tarjeta) {
        Tarjeta updated = tarjetaServi.updateTarjeta(id_tarjeta, tarjeta);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_tarjeta}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_tarjeta) {
        try {
            tarjetaServi.deleteTarjeta(id_tarjeta);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
