package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.model.Facility;
import com.example.demo.model.User;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final FacilityRepository facilityRepository;
    private final UserRepository userRepository;
    private final BookingLogRepository bookingLogRepository;

    public BookingServiceImpl(
            BookingRepository bookingRepository,
            FacilityRepository facilityRepository,
            UserRepository userRepository,
            BookingLogRepository bookingLogRepository) {

        this.bookingRepository = bookingRepository;
        this.facilityRepository = facilityRepository;
        this.userRepository = userRepository;
        this.bookingLogRepository = bookingLogRepository;
    }

    @Override
    public Booking createBooking(Long facilityId, Long userId, Booking booking) {

        Facility facility = facilityRepository.findById(facilityId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        List<Booking> conflicts =
                bookingRepository.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                        facility,
                        booking.getEndTime(),
                        booking.getStartTime()
                );

        if (!conflicts.isEmpty()) {
            throw new ConflictException("Booking conflict");
        }

        booking.setFacility(facility);
        booking.setUser(user);
        booking.setStatus(Booking.STATUS_CONFIRMED);

        Booking saved = bookingRepository.save(booking);

        // ✅ CRITICAL FIX FOR t14
        bookingLogRepository.save(
                new BookingLog(null, saved, "Booking created", null)
        );

        return saved;
    }

    @Override
    public Booking cancelBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        booking.setStatus(Booking.STATUS_CANCELLED);

        Booking saved = bookingRepository.save(booking);

        bookingLogRepository.save(
                new BookingLog(null, saved, "Booking cancelled", null)
        );

        return saved;
    }

    @Override
    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow();
    }
}
