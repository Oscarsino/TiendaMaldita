package com.example.gerente.service;

public interface FacturaService {
    List<FacturaDTO.Reponse> listar();
    FacturaDTO.Reponse buscarId( int id);
    FacturaDTO.Reponse crear (FacturaDTO.Request request);
    FacturaDTO.Reponse actualizar (int id , DetalleDTO.Request request);
    void eliminar (int id);

}
