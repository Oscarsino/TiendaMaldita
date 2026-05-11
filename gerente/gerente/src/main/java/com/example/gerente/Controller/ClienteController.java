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

import com.example.gerente.Service.ClienteService;
import com.example.gerente.model.Cliente;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteServi;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> c = clienteServi.getAllCliente();
        if (c.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(c);
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity<Cliente> buscarById(@PathVariable int id_cliente) {
        Cliente c = clienteServi.getClienteById(id_cliente);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteServi.createCliente(cliente));
    }

    @PutMapping("/{id_cliente}")
    public ResponseEntity<Cliente> actualizar(@PathVariable int id_cliente, @RequestBody Cliente cliente) {
        Cliente updated = clienteServi.updateCliente(id_cliente, cliente);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id_cliente}")
    public ResponseEntity<Void> eliminar(@PathVariable int id_cliente) {
        try {
            clienteServi.deleteCliente(id_cliente);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
