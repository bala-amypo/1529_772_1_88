package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;

@RestController
@RequestMapping("/logs")
public class BookingLogController {

    @Autowired
    private BookingLogService bookingLogService;

    
    @GetMapping("/booking/{bookingId}")
    public List<BookingLog> getLogsByBooking(@PathVariable Long bookingId) {
        return bookingLogService.getLogsByBooking(bookingId);
    }
    @GetMapping
public List<BookingLog> getAllLogs() {
    return bookingLogService.getAllLogs();
}
@PostMapping("/add")
public BookingLog addLog(@RequestBody BookingLogRequest request) {
    return bookingLogService.addLog(
            request.getBookingId(),
            request.getLogMessage()
    );
}
@PostMapping
public BookingLog addLog(@RequestBody BookingLog bookingLog) {
    return bookingLogService.saveLog(bookingLog);
}


}
