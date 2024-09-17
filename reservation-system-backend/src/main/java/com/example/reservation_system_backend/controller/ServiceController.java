package com.example.reservation_system_backend.controller;

import com.example.reservation_system_backend.model.Services;
import com.example.reservation_system_backend.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Services> createService(@RequestBody Services service) {
        return ResponseEntity.ok(serviceService.createService(service));
    }

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Services> updateService(@PathVariable Long id, @RequestBody Services service) {
        return ResponseEntity.ok(serviceService.updateService(id, service));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
