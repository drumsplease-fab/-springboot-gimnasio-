package com.libcode.gimnasio.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "miembros")
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;

    @Column
    private String apellido;
    
    @Column
    private String email;
    
    @Column
    private String telefono;

    @Column
    private LocalDate fechaNacimiento;

    @Column
    private String direccion;
    
    @OneToMany(mappedBy = "miembro", cascade = CascadeType.ALL)
    private List<Membresia> membresias = new ArrayList<>();
    
    @Transient // O usa @Formula para consultas derivadas
    private Membresia membresiaActiva;
    
    // Método para obtener membresía activa
    public Membresia getMembresiaActiva() {
        return this.membresias.stream()
            .filter(m -> m.isActiva() && !m.isExpirada())
            .findFirst()
            .orElse(null);
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Membresia> getMembresias() {
        return membresias;
    }

    public void setMembresias(List<Membresia> membresias) {
        this.membresias = membresias;
    }

    public void setMembresiaActiva(Membresia membresiaActiva) {
        this.membresiaActiva = membresiaActiva;
    }


}
