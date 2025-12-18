package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;

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

        if (booking.getEndTime().isBefore(booking.getStartTime())) {
            throw new ConflictException("End time must be after start time");
        }

        Facility facility = facilityRepository.findById(facilityId).orElseThrow();
        UserEntity user = userRepository.findById(userId).orElseThrow();

        // conflict check
        List<Booking> conflicts =
                bookingRepository.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                        facility,
                        booking.getEndTime(),
                        booking.getStartTime()
                );

        if (!conflicts.isEmpty()) {
            throw new ConflictException("Booking time conflict");
        }

        booking.setFacility(facility);
        booking.setUser(user);
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        booking.setStatus("CANCELLED");
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow();
    }
}
