package com.booking.models;

public class BookingResponse {
    private int bookingid;
    private Booking booking; // Nested object

    // Getters and Setters
    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}

