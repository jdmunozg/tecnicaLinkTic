package com.example.reservation_system_backend.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Email(message = "El email debe ser válido")
    @NotNull(message = "El email es obligatorio")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "El número de teléfono debe tener 10 dígitos")
    @NotNull(message = "El teléfono es obligatorio")
    private String phone;

    // Constructor vacío
    public Customer() {}

    // Constructor con parámetros
    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
