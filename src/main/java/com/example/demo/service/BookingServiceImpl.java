package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Booking;

@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public Booking createBooking(Long userId, Long facilityId, Booking booking) {
        booking.setUserId(userId);
        booking.setFacilityId(facilityId);
        return booking;
    }

    @Override
    public Booking getBooking(Long bookingId) {
        Booking booking = new Booking();
        booking.setId(bookingId);
        return booking;
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        Booking booking = new Booking();
        booking.setId(bookingId);
        booking.setStatus("CANCELLED");
        return booking;
    }
}
