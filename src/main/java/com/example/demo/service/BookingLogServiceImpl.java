package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    @Autowired
    private BookingLogRepository bookingLogRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingLog addLog(Long bookingId, String message) {

        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking == null) {
            return null;
        }

        BookingLog log = new BookingLog();
        log.setBooking(booking);
        log.setLogMessage(message);

        return bookingLogRepository.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking == null) {
            return null;
        }

        return bookingLogRepository.findByBookingOrderByLoggedAtAsc(booking);
    }
    @Override
public List<BookingLog> getAllLogs() {
    return bookingLogRepository.findAll();
}


  
}
