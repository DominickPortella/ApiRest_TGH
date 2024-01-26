package com.example.API.servicios;
import com.example.API.modelos.Cliente;
import com.example.API.modelos.Renta;
import java.util.List;
import java.util.Map;

public interface ClienteServicio {
    Cliente guardarCliente(Cliente cliente);
    List<Cliente> obtenerTodosLosClientes();
    Cliente obtenerClientePorId(Long id);
    void eliminarCliente(Long id);

    // Nuevo método para obtener productos de una categoría
    List<Renta> obtenerRentasPorClientes(Long clienteId);
    Cliente actualizarCliente(Long id,Cliente clienteActualizado);
    Cliente actualizarCampoCliente(Long id, Map<String, Object> camposActualizados);
}
