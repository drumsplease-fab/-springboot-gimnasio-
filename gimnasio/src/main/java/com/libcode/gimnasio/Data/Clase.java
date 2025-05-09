package com.libcode.gimnasio.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clases")
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private LocalDateTime horario;

    @Column
    private int duracion;
    
    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;
    
    @OneToMany(mappedBy = "clase")
    private List<AsistenciaClase> asistencias = new ArrayList<>();

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public LocalDateTime getHorario() {
        return horario;
    }



    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }



    public int getDuracion() {
        return duracion;
    }



    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }



    public Entrenador getEntrenador() {
        return entrenador;
    }



    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }



    public List<AsistenciaClase> getAsistencias() {
        return asistencias;
    }



    public void setAsistencias(List<AsistenciaClase> asistencias) {
        this.asistencias = asistencias;
    }

    public void registrarAsistencia(AsistenciaClase asistencia) {
        asistencias.add(asistencia);
        asistencia.setClase(this);
    }
}
