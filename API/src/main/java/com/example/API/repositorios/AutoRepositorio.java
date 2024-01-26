package com.example.API.repositorios;

import com.example.API.modelos.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepositorio extends JpaRepository<Auto, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
