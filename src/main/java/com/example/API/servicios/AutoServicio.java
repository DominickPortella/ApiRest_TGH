package com.example.API.servicios;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.API.modelos.Auto;
import com.example.API.modelos.Renta;

public interface AutoServicio {

    Auto guardarAuto(Auto auto);

    List<Auto> obtenerTodosLosAutos();

    Auto obtenerAutoPorId(Long id);
    void eliminarAuto(Long id);

    String constructImageUrl(String imageName);
    // Nuevo método para obtener productos de una categoría
    List<Renta> obtenerRentasPorAutos(Long autoId);

    Auto actualizarAuto(Long id,Auto autoActualizado);
    Auto actualizarCampoAuto(Long id, Map<String, Object> camposActualizados);

}
