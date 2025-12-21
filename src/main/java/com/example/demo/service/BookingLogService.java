package com.example.demo.service;

import java.util.List;
import com.example.demo.model.BookingLog;

public interface BookingLogService {

   

    List<BookingLog> getLogsByBooking(Long bookingId);
    List<BookingLog> getAllLogs();
  
BookingLog addLog(Long bookingId, String message);
BookingLog saveLog(BookingLog bookingLog);



}
