package com.florista.florista.service;

import com.florista.florista.model.Booking;
import com.florista.florista.model.Gardener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    private List<Booking> bookings = new ArrayList<>();
    private int bookingCounter = 1;

    private final GardenerService gardenerService;

    public BookingService(GardenerService gardenerService) {
        this.gardenerService = gardenerService;
    }

    // ✅ Create booking (VALIDATED)
    public Booking createBooking(Long gardenerId, String userEmail, String date) {
        Gardener gardener = gardenerService.getGardenerById(gardenerId);
        if (gardener == null) {
            throw new RuntimeException("Gardener not found");
        }
        Booking booking = new Booking(
                bookingCounter++,
                gardenerId.intValue(),
                userEmail,
                date,
                "PENDING"
        );
        bookings.add(booking);
        return booking;
    }

    // ✅ Get all bookings
    public List<Booking> getAllBookings() {
        return bookings;
    }

    // ✅ Get bookings by user
    public List<Booking> getUserBookings(String email) {
        List<Booking> result = new ArrayList<>();

        for (Booking b : bookings) {
            if (b.getUserEmail().equals(email)) {
                result.add(b);
            }
        }

        return result;
    }

    // ✅ Update status (IMPROVED)
    public String updateStatus(int bookingId, String status) {

        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {

                if (!List.of("PENDING", "ACCEPTED", "COMPLETED", "CANCELLED")
                        .contains(status.toUpperCase())) {
                    return "Invalid status";
                }

                b.setStatus(status.toUpperCase());
                return "Status updated";
            }
        }

        return "Booking not found";
    }
}