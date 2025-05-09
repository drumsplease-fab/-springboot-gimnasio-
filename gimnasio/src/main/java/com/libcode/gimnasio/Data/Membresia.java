package com.libcode.gimnasio.Data;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "membresias")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String tipo;

    @Column
    private LocalDate fechaInicio;

    @Column
    private LocalDate fechaExpiracion;

    @Column
    private double costo;
    
  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "miembro_id")
    private Miembro miembro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public boolean isActiva() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isActiva'");
    }

    public boolean isExpirada() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExpirada'");
    }
    
}   
