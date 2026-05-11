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

import com.example.gerente.Service.EmpleadoService;
import com.example.gerente.model.Empleado;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoServi;

    @GetMapping
    public ResponseEntity<List<Empleado>> listar() {
        List<Empleado> e = empleadoServi.getAllEmpleado();
        if (e.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(e);
    }

    @GetMapping("/{id_empleado}")
    public ResponseEntity<Empleado> buscarById(@PathVariable int id_empleado) {
        Empleado e = empleadoServi.getEmpleadoById(id_empleado);
        if (e == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(e);
    }

    @PostMapping
    public ResponseEntity<Empleado> guardar(@RequestBody Empleado empleado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoServi.createEmpleado(empleado));
    }

    @PutMapping("/{id_empleado}")
    public ResponseEntity<Empleado> actualizar(@PathVariable int id_empleado, @RequestBody Empleado empleado) {
        Empleado updated = empleadoServi.updateEmpleado(id_empleado, empleado);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_empleado}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_empleado) {
        try {
            empleadoServi.deleteEmpleado(id_empleado);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
