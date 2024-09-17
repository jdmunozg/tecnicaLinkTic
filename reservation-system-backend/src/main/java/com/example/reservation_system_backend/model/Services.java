package com.example.reservation_system_backend.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre del servicio es obligatorio")
    private String serviceName;

    // Constructor vacío
    public Services() {}

    // Constructor con parámetros
    public Services(String serviceName) {
        this.serviceName = serviceName;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}