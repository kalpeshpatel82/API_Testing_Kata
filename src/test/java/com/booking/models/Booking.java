package com.booking.models;

public class Booking {
    private int roomid;
    private String firstname;
    private String lastname;
    private boolean depositpaid;
    private BookingDates bookingdates; // Nested object
    private String email;
    private String phone;

    public String toString() {
        StringBuffer str = new  StringBuffer();
        str.append("{\"roomid\":"+roomid+" \"firstname\": \"John\",\"lastname\": \"Doe\",\"depositpaid\": true,\"bookingdates\": {\"checkin\": \"2025-10-13\",\"checkout\": \"2025-10-15\"},\"email\": \"john.doe@example.com\",\"phone\": \"1234567890\"}");
        return str.toString();
    }

    // Getters and Setters
    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


