package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository bookingLogRepository;
    private final BookingRepository bookingRepository;

    public BookingLogServiceImpl(BookingLogRepository bookingLogRepository,
                                 BookingRepository bookingRepository) {
        this.bookingLogRepository = bookingLogRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingLog addLog(Long bookingId, String message) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        BookingLog log = new BookingLog(null, booking, message, null);
        return bookingLogRepository.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        return bookingLogRepository.findByBookingOrderByLoggedAtAsc(booking);
    }
}
