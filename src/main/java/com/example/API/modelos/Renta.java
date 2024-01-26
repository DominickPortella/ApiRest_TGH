package com.example.API.modelos;
import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Renta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double tarifaDiaria; 
    private double totalPaga;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_id")
    private Auto auto;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    // Constructores, getters y setters



    public Renta(LocalDate fechaInicio, LocalDate fechaFin, double tarifaDiaria, double totalPaga) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tarifaDiaria = tarifaDiaria;
        this.totalPaga = totalPaga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }

    public double getTotalPaga() {
        return totalPaga;
    }

    public void setTotalPaga(double totalPaga) {
        this.totalPaga = totalPaga;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Renta() {
        // Constructor vacío necesario para JPA
    }

    
}
