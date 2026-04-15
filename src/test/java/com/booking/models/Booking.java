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
        StringBuilder str = new StringBuilder();
        String json = """
                {
                  "roomid": %d,
                  "firstname": "%s",
                  "lastname": "%s",
                  "depositpaid": "%b",
                  "bookingdates": {
                    "checkin": "%s",
                    "checkout": "%s"
                  },
                  "email": "%s",
                  "phone": "%s"
                }
                """.formatted(roomid, firstname, lastname, depositpaid, bookingdates.getCheckin(), bookingdates.getCheckout(), email, phone);

        str.append(json);
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


