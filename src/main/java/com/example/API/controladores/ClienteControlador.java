package com.example.API.controladores;
import com.example.API.modelos.Cliente;
import com.example.API.modelos.Renta;
import com.example.API.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteServicio.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable Long id) {
        return clienteServicio.obtenerClientePorId(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        return clienteServicio.guardarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarCliente(id);
    }

    @GetMapping("/{clienteId}/rentas")
    public List<Renta> obtenerRentasPorClientes(@PathVariable Long clienteId) {
        return clienteServicio.obtenerRentasPorClientes(clienteId);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        return clienteServicio.actualizarCliente(id, clienteActualizado);
    }
    @PatchMapping("/{id}")
    public Cliente actualizarCampoCliente(@PathVariable Long id, @RequestBody Map<String, Object> camposActualizados) {
        return clienteServicio.actualizarCampoCliente(id, camposActualizados);
    }
}
