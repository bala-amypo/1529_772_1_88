package com.example.demo.service;

import com.example.demo.model.Booking;

public interface BookingService {

    Booking createBooking(Long userId, Long facilityId, Booking booking);

    Booking getBooking(Long bookingId);

    Booking cancelBooking(Long bookingId);
}
