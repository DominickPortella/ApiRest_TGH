package com.example.API.servicios;
import com.example.API.modelos.Cliente;
import com.example.API.modelos.Renta;
import com.example.API.repositorios.ClienteRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    // Autowire el servicio de Producto para acceder a su funcionalidad
    @Autowired
    private RentaServicio rentaServicio;

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }

    @Override
    public List<Renta> obtenerRentasPorClientes(Long clienteId) {
        // Puedes utilizar el servicio de Producto para obtener los productos por categoría
        return rentaServicio.obtenerRentasPorClientes(clienteId);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente clienteExistente = clienteRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));

        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setApellido(clienteActualizado.getApellido());
        clienteExistente.setDni(clienteActualizado.getDni());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setEmail(clienteActualizado.getEmail());
        clienteExistente.setDireccion(clienteActualizado.getDireccion());

        return clienteRepositorio.save(clienteExistente);
    }

    @Override
    public Cliente actualizarCampoCliente(Long id, Map<String, Object> camposActualizados) {
        Cliente cliente = clienteRepositorio.findById(id).orElse(null);

        if (cliente != null) {
            camposActualizados.forEach((campo, valor) -> {
                switch (campo) {
                    case "nombre":
                        cliente.setNombre((String) valor);
                        break;
                    case "apellido":
                        cliente.setApellido((String) valor);
                        break;
                    case "dni":
                        cliente.setDni((int) valor);
                        break;
                    case "telefono":
                        cliente.setTelefono((int) valor);
                        break;
                    case "email":
                        cliente.setEmail((String) valor);
                        break;
                    case "direccion":
                        cliente.setDireccion((String) valor);
                        break;
                    // Agrega más campos según sea necesario
                    default:
                        // Manejo para campos no reconocidos
                }
            });

            return clienteRepositorio.save(cliente);
        }

        return null;
}

}
