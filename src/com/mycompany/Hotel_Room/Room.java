package com.mycompany.Hotel_Room;

public abstract class Room {
    protected String bookerName;
    protected String type;
    protected String roomNumber;
    protected double price;
    protected boolean isAvailable;
    protected String bookingDate;
    protected int stayTime;

    public Room(String type, String roomNumber, double price) {
        this.type = type;
        this.roomNumber = roomNumber;
        this.price = price;
        this.isAvailable = true;
    }

    public String getType() {
        return type;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPrice() {
        return price;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public int getStayTime() {
        return stayTime;
    }

    public void bookRoom(String bookerName, String bookingDate, int stayTime) {
        if (isAvailable) {
            this.bookerName = bookerName;
            this.bookingDate = bookingDate;
            this.stayTime = stayTime;
            this.isAvailable = false;
            System.out.printf("\nRoom %s is successfully booked by %s for %d days. Booking date: %s\n", 
                               this.roomNumber, this.bookerName, this.stayTime, this.bookingDate);
        } else {
            System.out.printf("\nRoom %s is already booked.\n", this.roomNumber);
        }
    }

    public abstract String showFacilities();

    public double calculateTotalCost() {
        double finalPrice = this.price * stayTime;
        return finalPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
