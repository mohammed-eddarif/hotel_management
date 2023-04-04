package com.hotel.management.hotel_management.model.others;

import java.util.Date;

public class ReservationRoom {
    private int id;
    private int id_room;
    private Date checkInDate;
    private Date checkOutDate;
    private String fullName;
    private String email;
    private String phone;

    public ReservationRoom() {
    }

    public ReservationRoom(int id, int id_room, Date checkInDate, Date checkOutDate, String fullName, String email, String phone) {
        this.id = id;
        this.id_room = id_room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public ReservationRoom(int id_room, Date checkInDate, Date checkOutDate, String fullName, String email, String phone) {
        this.id_room = id_room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public ReservationRoom(int id, int id_room) {
        this.id = id;
        this.id_room = id_room;
    }

    public ReservationRoom(Date checkInDate, Date checkOutDate, String fullName, String email, String phone) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
