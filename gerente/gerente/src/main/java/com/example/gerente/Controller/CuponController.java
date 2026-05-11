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

import com.example.gerente.Service.CuponService;
import com.example.gerente.model.Cupon;

@RestController
@RequestMapping("/api/cupon")
public class CuponController {

    @Autowired
    private CuponService cuponServi;

    @GetMapping
    public ResponseEntity<List<Cupon>> listar() {
        List<Cupon> c = cuponServi.getAllCupon();
        if (c.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(c);
    }

    @GetMapping("/{id_cupon}")
    public ResponseEntity<Cupon> buscarById(@PathVariable int id_cupon) {
        Cupon c = cuponServi.getCuponById(id_cupon);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Cupon> guardar(@RequestBody Cupon cupon) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cuponServi.createCupon(cupon));
    }

    @PutMapping("/{id_cupon}")
    public ResponseEntity<Cupon> actualizar(@PathVariable int id_cupon, @RequestBody Cupon cupon) {
        Cupon updated = cuponServi.updateCupon(id_cupon, cupon);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_cupon}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_cupon) {
        try {
            cuponServi.deleteCupon(id_cupon);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
