package com.codeclan.example.courseBookingSystem.controllers;


import com.codeclan.example.courseBookingSystem.models.Course;
import com.codeclan.example.courseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {


    @Autowired
    CourseRepository courseRepository;



    @GetMapping
    public ResponseEntity<List<Course>> getAllCoursesAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "starRating") Integer starRating,
            @RequestParam(required = false, name = "town") String town

    ){
        if (starRating != null){
            return new ResponseEntity(courseRepository.findByStarRating(starRating), HttpStatus.OK);
        }
        if (name != null){
            return new ResponseEntity(courseRepository.findByName(name), HttpStatus.OK);
        }
        if (town != null){
            return new ResponseEntity(courseRepository.findByTown(town), HttpStatus.OK);
        }

        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

}
