package com.example.gerente.service;

public interface DetalleService {
    List<DetalleDTO.Reponse> listar();
    DetalleDTO.Reponse buscarPorId(int id_detalle);
    DetalleDTO.Reponse crear (DetalleDTO.Request request);
    DetalleDTO.Reponse actualizar (int id_detalle DetalleDTO.Request request);
    DetalleDTO void eliminar (int id_detalle);

}
