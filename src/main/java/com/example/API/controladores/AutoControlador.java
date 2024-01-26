package com.example.API.controladores;

import com.example.API.modelos.Auto;
import com.example.API.modelos.Renta;
import com.example.API.servicios.AutoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/autos")
public class AutoControlador {

    @Autowired
    private AutoServicio autoServicio;

    @GetMapping
    public List<Auto> obtenerTodosLosAutos() {
        return autoServicio.obtenerTodosLosAutos();
    }

    @GetMapping("/{id}")
    public Auto obtenerAutoPorId(@PathVariable Long id) {
        return autoServicio.obtenerAutoPorId(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Auto> guardarAuto(@RequestBody Auto auto) {
        Auto nuevoAuto = autoServicio.guardarAuto(auto);

        if (nuevoAuto.getImagen() != null) {
            String imageUrl = autoServicio.constructImageUrl(nuevoAuto.getImagen());
            nuevoAuto.setImagen(imageUrl);
        }

        return new ResponseEntity<>(nuevoAuto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarAuto(@PathVariable Long id) {
        autoServicio.eliminarAuto(id);
    }

    @GetMapping("/{autoId}/rentas")
    public List<Renta> obtenerRentasPorAutos(@PathVariable Long autoId) {
        return autoServicio.obtenerRentasPorAutos(autoId);
    }
    @PutMapping("/{id}")
    public Auto actualizarAuto(@PathVariable Long id, @RequestBody Auto autoActualizado) {
        return autoServicio.actualizarAuto(id, autoActualizado);

    }
    @PatchMapping("/{id}")
    public Auto actualizarCamposAuto(@PathVariable Long id, @RequestBody Map<String, Object> camposActualizados) {
        return autoServicio.actualizarCampoAuto(id, camposActualizados);
    }
}
