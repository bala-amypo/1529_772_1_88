package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Booking;

@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public Booking createBooking(Booking booking) {
        booking.setStatus(Booking.STATUS_CONFIRMED);
        return booking;
    }

    @Override
    public Booking getBooking(Long id) {
        Booking booking = new Booking();
        booking.setId(id);
        booking.setStatus(Booking.STATUS_CONFIRMED);
        return booking;
    }

    @Override
    public Booking cancelBooking(Long id) {
        Booking booking = new Booking();
        booking.setId(id);
        booking.setStatus(Booking.STATUS_CANCELLED);
        return booking;
    }
}
