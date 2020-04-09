package com.codeclan.example.courseBookingSystem.controllers;


import com.codeclan.example.courseBookingSystem.models.Booking;
import com.codeclan.example.courseBookingSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public ResponseEntity getAllBookingsAndFilters(
            @RequestParam(required = false, name = "date") String date,
            @RequestParam(required = false, name = "customerName") String customerName,
            @RequestParam(required = false, name = "courseName") String courseName
    ){
        if(date != null){
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        if (courseName != null) {
            return new ResponseEntity(bookingRepository.findByCourse(courseName), HttpStatus.OK);
        }
        if (customerName != null && courseName != null) {
            List<Booking> foundBooking = bookingRepository.findByCustomerNameAndCourseNameIgnoreCase(customerName, courseName);
            return new ResponseEntity(foundBooking, HttpStatus.OK);
        }
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }



}
