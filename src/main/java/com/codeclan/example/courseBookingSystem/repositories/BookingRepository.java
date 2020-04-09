package com.codeclan.example.courseBookingSystem.repositories;


import com.codeclan.example.courseBookingSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {




}
