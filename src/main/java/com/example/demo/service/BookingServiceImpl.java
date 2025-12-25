package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Booking createBooking(Long facilityId, Long userId, Booking booking) {

        Facility facility = facilityRepository.findById(facilityId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        booking.setFacility(facility);
        booking.setUser(user);
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) {
            booking.setStatus("CANCELLED");
            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }
}
