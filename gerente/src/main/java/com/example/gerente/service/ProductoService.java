package com.example.gerente.service;

public interface ProductoService {
    List<ProductoDTO.Response> listarProducto();
    ProductoDTo.Response buscarPorId (int id_producto);
    ProductoDTO.Response crear (ProductoDTO.request request);
    ProductoDTO.Response actualizar (int id_producto , ProductoDTO request);
    void eliminar (int id_producto);


}
