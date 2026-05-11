package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.ClienteRepository;
import com.example.gerente.model.Cliente;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    public List<Cliente> getAllCliente() {
        return clienteRepo.findAll();
    }

    public Cliente getClienteById(int id_cliente) {
        Optional<Cliente> cliente = clienteRepo.findByid_cliente(id_cliente);
        return cliente.orElse(null);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public void deleteCliente(int id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }

    public Cliente updateCliente(int id_cliente, Cliente cliente) {
        Cliente existing = getClienteById(id_cliente);
        if (existing != null) {
            existing.setNombre(cliente.getNombre());
            existing.setApellido(cliente.getApellido());
            existing.setEmail(cliente.getEmail());
            return clienteRepo.save(existing);
        }
        return null;
    }
}
