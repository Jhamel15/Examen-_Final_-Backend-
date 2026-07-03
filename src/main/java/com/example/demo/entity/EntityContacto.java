package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contactos")
public class EntityContacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String asunto;

    @Column(length = 1500)
    private String mensaje;

    private LocalDate fecha;

    public EntityContacto() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}