package com.example.reservation_system_backend.service;


import com.example.reservation_system_backend.exception.ResourceNotFoundException;
import com.example.reservation_system_backend.model.Reservation;
import com.example.reservation_system_backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByDate(LocalDate date) {
        return reservationRepository.findByReservationDate(date);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        reservation.setReservationDate(reservationDetails.getReservationDate());
        reservation.setReservationTime(reservationDetails.getReservationTime());
        reservation.setCustomer(reservationDetails.getCustomer());
        reservation.setService(reservationDetails.getService());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}