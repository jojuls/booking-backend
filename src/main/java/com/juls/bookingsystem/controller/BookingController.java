package com.juls.bookingsystem.controller;

import com.juls.bookingsystem.entity.Booking;
import com.juls.bookingsystem.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("*")
public class BookingController {

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Integer id, @RequestBody Booking updatedBooking) {
        Booking booking = bookingRepository.findById(id).orElseThrow();

        booking.setCustomerName(updatedBooking.getCustomerName());
        booking.setEmail(updatedBooking.getEmail());
        booking.setPhone(updatedBooking.getPhone());
        booking.setServiceName(updatedBooking.getServiceName());
        booking.setPreferredDate(updatedBooking.getPreferredDate());
        booking.setPreferredTime(updatedBooking.getPreferredTime());
        booking.setMessage(updatedBooking.getMessage());
        booking.setStatus(updatedBooking.getStatus());

        return bookingRepository.save(booking);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Integer id) {
        bookingRepository.deleteById(id);
        return "Booking deleted successfully";
    }
}