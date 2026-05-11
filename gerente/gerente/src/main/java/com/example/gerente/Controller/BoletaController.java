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

import com.example.gerente.Service.BoletaService;
import com.example.gerente.model.Boleta;

@RestController
@RequestMapping("/api/boleta")
public class BoletaController {

    @Autowired
    private BoletaService boletaServi;

    @GetMapping
    public ResponseEntity<List<Boleta>> listar() {
        List<Boleta> b = boletaServi.getAllBoleta();
        if (b.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(b);
    }

    @GetMapping("/{id_boleta}")
    public ResponseEntity<Boleta> buscarById(@PathVariable int id_boleta) {
        Boleta b = boletaServi.getBoletaById(id_boleta);
        if (b == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(b);
    }

    @PostMapping
    public ResponseEntity<Boleta> guardar(@RequestBody Boleta boleta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(boletaServi.createBoleta(boleta));
    }

    @PutMapping("/{id_boleta}")
    public ResponseEntity<Boleta> actualizar(@PathVariable int id_boleta, @RequestBody Boleta boleta) {
        Boleta updated = boletaServi.updateBoleta(id_boleta, boleta);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_boleta}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_boleta) {
        try {
            boletaServi.deleteBoleta(id_boleta);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
