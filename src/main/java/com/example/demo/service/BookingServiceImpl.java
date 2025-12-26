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
    bookingLogService.addLog(saved.getId(), "Booking created");

    return saved;
}
