package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    public BookingServiceImpl(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(Booking booking) {
        booking.setStatus(Booking.STATUS_CONFIRMED);
        return repository.save(booking);
    }

    public void cancelBooking(Long id) {
        Booking booking = repository.findById(id).orElseThrow();
        booking.setStatus(Booking.STATUS_CANCELLED);
        repository.save(booking);
    }

    public Booking getBooking(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
