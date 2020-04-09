package com.codeclan.example.courseBookingSystem.components;


import com.codeclan.example.courseBookingSystem.models.Booking;
import com.codeclan.example.courseBookingSystem.models.Course;
import com.codeclan.example.courseBookingSystem.models.Customer;
import com.codeclan.example.courseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.courseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.courseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course1 = new Course("Beginners", "Edinburgh", 4);
        courseRepository.save(course1);

        Course course2 = new Course("Intermediate", "Glasgow", 2);
        courseRepository.save(course2);

        Course course3 = new Course("Advanced", "Edinburgh", 5);
        courseRepository.save(course3);

        Customer customer1 = new Customer("Noel", "Nairn", 48);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Malcolm", "Lasswade", 33);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("04-06-2020", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("13-01-2021", customer1, course2);
        bookingRepository.save(booking2);


        Booking booking3 = new Booking("13-01-2021", customer2, course2);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("13-04-2021", customer2, course3);
        bookingRepository.save(booking4);

    }
}
