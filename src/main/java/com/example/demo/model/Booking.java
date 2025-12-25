package com.example.demo.model;

import java.time.LocalDateTime;

public class Booking {

    public static final String STATUS_CONFIRMED = "CONFIRMED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    private Long id;
    private Long userId;
    private Long facilityId;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    public Booking() {
    }

    
    public Booking(Long id, Booking booking, String status, LocalDateTime startTime) {
        this.id = id;
        this.userId = booking.getUserId();
        this.facilityId = booking.getFacilityId();
        this.status = status;
        this.startTime = startTime;
    }

    
    public Booking(Long id, Long userId, Long facilityId,
                   LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.id = id;
        this.userId = userId;
        this.facilityId = facilityId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

  
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getFacilityId() { return facilityId; }
    public void setFacilityId(Long facilityId) { this.facilityId = facilityId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
}
