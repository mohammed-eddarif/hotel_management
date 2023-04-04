package com.hotel.management.hotel_management.model.others;

import java.util.Date;

public class ReservationSalle {
    private int id;
    private int id_salle;
    private Date checkInDate;
    private Date checkOutDate;
    private String fullName;
    private String email;
    private String phone;

    public ReservationSalle(int id, int id_salle, Date checkInDate, Date checkOutDate, String fullName, String email, String phone) {
        this.id = id;
        this.id_salle = id_salle;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public ReservationSalle(int id_salle, Date checkInDate, Date checkOutDate, String fullName, String email, String phone) {
        this.id_salle = id_salle;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public ReservationSalle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
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
