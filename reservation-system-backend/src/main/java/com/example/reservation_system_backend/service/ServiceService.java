package com.example.reservation_system_backend.service;


import com.example.reservation_system_backend.exception.ResourceNotFoundException;
import com.example.reservation_system_backend.model.Services;
import com.example.reservation_system_backend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Services createService(Services service) {
        return serviceRepository.save(service);
    }

    public List<Services> getAllServices() {
        return serviceRepository.findAll();
    }

    public Services updateService(Long id, Services serviceDetails) {
        Services service = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id: " + id));
        service.setServiceName(serviceDetails.getServiceName());
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
