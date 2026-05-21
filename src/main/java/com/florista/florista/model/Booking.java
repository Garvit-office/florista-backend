package com.florista.florista.model;

public class Booking {

    private int bookingId;
    private int gardenerId;
    private String userEmail;
    private String date;
    private String status;

    public Booking() {}

    public Booking(int bookingId, int gardenerId, String userEmail, String date, String status) {
        this.bookingId = bookingId;
        this.gardenerId = gardenerId;
        this.userEmail = userEmail;
        this.date = date;
        this.status = status;
    }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getGardenerId() { return gardenerId; }
    public void setGardenerId(int gardenerId) { this.gardenerId = gardenerId; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}