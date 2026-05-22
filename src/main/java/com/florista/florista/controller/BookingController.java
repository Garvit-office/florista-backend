package com.florista.florista.controller;

import com.florista.florista.model.Booking;
import com.florista.florista.service.BookingService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // ✅ Create booking
    @PostMapping("/create")
    public Booking create(@RequestBody Map<String, String> request) {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        Long gardenerId = Long.parseLong(request.get("gardenerId"));
        String date = request.get("date");

        return bookingService.createBooking(gardenerId, email, date);
    }

    // ✅ My bookings
    @GetMapping("/my")
    public List<Booking> myBookings() {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return bookingService.getUserBookings(email);
    }

    // ✅ All bookings
    @GetMapping("/all")
    public List<Booking> all() {
        return bookingService.getAllBookings();
    }

    // ✅ Update status
    @PutMapping("/status/{id}")
    public String update(@PathVariable int id,
                         @RequestBody Map<String, String> request) {

        return bookingService.updateStatus(id, request.get("status"));
    }
}