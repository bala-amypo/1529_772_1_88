package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(User user, Facility facility,
                                 LocalDateTime startTime,
                                 LocalDateTime endTime) {

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setFacility(facility);
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setStatus("BOOKED");

        return bookingRepository.save(booking);
    }
}
