package com.example.API.servicios;

import com.example.API.modelos.Renta;

import java.util.List;

public interface RentaServicio {
    Renta guardarRenta(Renta renta);
    List<Renta> obtenerTodasLasRentas();
    Renta obtenerRentaPorId(Long id);
    void eliminarRenta(Long id);
    List<Renta> buscarportarifaDiaria(double tarifaDiaria);
    List<Renta> obtenerRentasPorAutos(Long autoId);
    List<Renta> obtenerRentasPorClientes(Long clienteId);

}
