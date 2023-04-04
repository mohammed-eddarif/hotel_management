package com.hotel.management.hotel_management.model.places;

public class Salle {
    private int id_salle;
    private int floor;
    private int nbr_places;
    private float price_per_day;

    public Salle() {
    }

    public Salle(int id_salle, int floor, int nbr_places, float price_per_day) {
        this.id_salle = id_salle;
        this.floor = floor;
        this.nbr_places = nbr_places;
        this.price_per_day = price_per_day;
    }

    public Salle(int floor, int nbr_places, float price_per_day) {
        this.floor = floor;
        this.nbr_places = nbr_places;
        this.price_per_day = price_per_day;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNbr_places() {
        return nbr_places;
    }

    public void setNbr_places(int nbr_places) {
        this.nbr_places = nbr_places;
    }

    public float getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(float price_per_day) {
        this.price_per_day = price_per_day;
    }
}
