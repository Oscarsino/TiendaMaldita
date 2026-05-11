package com.example.gerente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerente.Repository.EmpleadoRepository;
import com.example.gerente.model.Empleado;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepo;

    public List<Empleado> getAllEmpleado() {
        return empleadoRepo.findAll();
    }

    public Empleado getEmpleadoById(int id_empleado) {
        Optional<Empleado> empleado = empleadoRepo.findByid_empleado(id_empleado);
        return empleado.orElse(null);
    }

    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepo.save(empleado);
    }

    public void deleteEmpleado(int id_empleado) {
        empleadoRepo.deleteById(id_empleado);
    }

    public Empleado updateEmpleado(int id_empleado, Empleado empleado) {
        Empleado existing = getEmpleadoById(id_empleado);
        if (existing != null) {
            existing.setNombre(empleado.getNombre());
            existing.setApellido(empleado.getApellido());
            existing.setSueldo(empleado.getSueldo());
            existing.setId_tienda(empleado.getId_tienda());
            return empleadoRepo.save(existing);
        }
        return null;
    }
}
