package com.codeclan.example.courseBookingSystem;

import com.codeclan.example.courseBookingSystem.models.Course;
import com.codeclan.example.courseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.courseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.courseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindByStarRating(){
		List<Course> foundCourse = courseRepository.findByStarRating(5);
	}

}
