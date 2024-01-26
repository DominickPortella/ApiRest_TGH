package com.example.API.repositorios;

import com.example.API.modelos.Renta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RentaRepositorio extends JpaRepository<Renta, Long> {
    List<Renta> findBytarifaDiaria(double tarifaDiaria);
    List<Renta> findByAutoId(Long autoId);
    List<Renta> findByClienteId(Long clienteId);
}
