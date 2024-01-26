package com.example.API.servicios;
import com.example.API.modelos.Auto;
import com.example.API.modelos.Renta;
import com.example.API.repositorios.AutoRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class AutoServicioImpl implements AutoServicio {

    @Autowired
    private AutoRepositorio autoRepositorio;

    // Autowire el servicio de Producto para acceder a su funcionalidad
    @Autowired
    private RentaServicio rentaServicio;

    @Override
    public Auto guardarAuto(Auto auto) {
        return autoRepositorio.save(auto);
    }

    @Override
    public List<Auto> obtenerTodosLosAutos() {
        return autoRepositorio.findAll();
    }

    @Override
    public Auto obtenerAutoPorId(Long id) {
        return autoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarAuto(Long id) {
        autoRepositorio.deleteById(id);
    }

    @Override
    public String constructImageUrl(String imageName) {
        // Lógica para construir la URL de la imagen basada en la ubicación de almacenamiento
        // Puedes concatenar el nombre de la imagen con la ruta base
        return "www.toyotacr.com/360/corolla/images/sp/8jpeg/COROLLA_040_02.jpg/" + imageName;
    }

    @Override
    public List<Renta> obtenerRentasPorAutos(Long autoId) {
        // Puedes utilizar el servicio de Producto para obtener los productos por categoría
        return rentaServicio.obtenerRentasPorAutos(autoId);
    }
    @Override
    public Auto actualizarAuto(Long id,Auto autoActualizado){
        Auto autoExistente = autoRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Auto no encontrado con id: " + id));
        autoExistente.setModelo(autoActualizado.getModelo());
        autoExistente.setMarca(autoActualizado.getMarca());
        autoExistente.setColor(autoActualizado.getColor());
        autoExistente.setAnio(autoActualizado.getAnio());
        autoExistente.setStock(autoActualizado.getStock());
        autoExistente.setEstado(autoActualizado.getEstado());
        autoExistente.setPlaca(autoActualizado.getPlaca());
        return autoRepositorio.save(autoExistente);
    }
    @Override
    public Auto actualizarCampoAuto(Long id, Map<String, Object> camposActualizados) {
        // Obtiene el Auto de la base de datos
        Auto auto = autoRepositorio.findById(id).orElse(null);

        if (auto != null) {
            // Actualiza los campos proporcionados
            camposActualizados.forEach((campo, valor) -> {
                switch (campo) {
                    case "modelo":
                        auto.setModelo((String) valor);
                        break;
                    case "marca":
                        auto.setMarca((String) valor);
                        break;
                    case "color":
                        auto.setColor((String) valor);
                        break;
                    case "anio":
                        auto.setAnio((Integer) valor);
                        break;
                    case "stock":
                        auto.setStock((Integer) valor);
                        break;
                    case "estado":
                        auto.setEstado((String) valor);
                        break;
                    case "placa":
                        auto.setPlaca((String) valor);
                        break;
                    default:
                }
            });
            return autoRepositorio.save(auto);
        }

        return null;}

}
