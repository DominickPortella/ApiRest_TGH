package com.example.API.controladores;

import com.example.API.modelos.Renta;
import com.example.API.servicios.RentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rentas")
public class RentaControlador {

    @Autowired
    private RentaServicio rentaServicio;

    @GetMapping
    public List<Renta> obtenerTodasLasRentas() {
        return rentaServicio.obtenerTodasLasRentas();
    }

    @GetMapping("/{id}")
    public Renta obtenerRentaPorId(@PathVariable Long id) {
        return rentaServicio.obtenerRentaPorId(id);
    }

    @PostMapping
    public Renta guardarRenta(@RequestBody Renta renta) {
        return rentaServicio.guardarRenta(renta);
    }

    @DeleteMapping("/{id}")
    public void eliminarRenta(@PathVariable Long id) {
        rentaServicio.eliminarRenta(id);
    }

    @GetMapping("/buscar")
    public List<Renta> buscarportarifaDiaria(@RequestParam double tarifaDiaria) {
        return rentaServicio.buscarportarifaDiaria(tarifaDiaria);
    }

    @GetMapping("/por-auto/{autoId}")
    public List<Renta> obtenerRentasPorAutos(@PathVariable Long autoId) {
        return rentaServicio.obtenerRentasPorAutos(autoId);
    }
    @GetMapping("/por-cliente/{clienteId}")
    public List<Renta> obtenerRentasPorClientes(@PathVariable Long clienteId) {
        return rentaServicio.obtenerRentasPorClientes(clienteId);
    }
}
