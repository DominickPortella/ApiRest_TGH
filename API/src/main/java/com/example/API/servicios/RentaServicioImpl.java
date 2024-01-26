package com.example.API.servicios;
import com.example.API.modelos.Auto;
import com.example.API.modelos.Cliente;
import com.example.API.modelos.Renta;
import com.example.API.repositorios.AutoRepositorio;
import com.example.API.repositorios.ClienteRepositorio;
import com.example.API.repositorios.RentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentaServicioImpl implements RentaServicio {

    @Autowired
    private RentaRepositorio rentaRepositorio;

    @Autowired
    private AutoRepositorio autoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public Renta guardarRenta(Renta renta) {
        // Verificar si la categoría existe antes de asociarla al producto
        if (renta.getCliente() != null && renta.getCliente().getId() != null) {
            Cliente cliente = clienteRepositorio.findById(renta.getCliente().getId()).orElse(null);
            if (cliente != null) {
                renta.setCliente(cliente);
            }
        }

        if (renta.getAuto() != null && renta.getAuto().getId() != null) {
            Auto auto = autoRepositorio.findById(renta.getAuto().getId()).orElse(null);
            if (auto != null) {
                renta.setAuto(auto);
            }
        }

        return rentaRepositorio.save(renta);
    }

    @Override
    public List<Renta> obtenerTodasLasRentas(){
        return rentaRepositorio.findAll();
    }

    @Override
    public Renta obtenerRentaPorId(Long id) {
        return rentaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarRenta(Long id) {
        rentaRepositorio.deleteById(id);
    }

    @Override
    public List<Renta> buscarportarifaDiaria(double tarifaDiaria) {
        return rentaRepositorio.findBytarifaDiaria(tarifaDiaria);
    }

    @Override
    public List<Renta> obtenerRentasPorAutos(Long autoId) {
        return rentaRepositorio.findByAutoId(autoId);
    }
    @Override
    public List<Renta> obtenerRentasPorClientes(Long clienteId) {
        return rentaRepositorio.findByClienteId(clienteId);
    }

    
}
