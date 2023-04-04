package com.hotel.management.hotel_management.model.places;

public class Room {
    private int room_id;
    private int floor;
    private int nbr_places;
    private float price_per_day;
    private boolean is_reserved = false;

    public Room() {
    }

    public Room(int room_id, int floor, int nbr_places, float price_per_day, boolean is_reserved) {
        this.room_id = room_id;
        this.floor = floor;
        this.nbr_places = nbr_places;
        this.price_per_day = price_per_day;
        this.is_reserved = is_reserved;
    }

    public Room(int room_id, int floor, int nbr_places, float price_per_day) {
        this.room_id = room_id;
        this.floor = floor;
        this.nbr_places = nbr_places;
        this.price_per_day = price_per_day;
    }

    public Room(int floor, int nbr_places, float price_per_day, boolean is_reserved) {
        this.floor = floor;
        this.nbr_places = nbr_places;
        this.price_per_day = price_per_day;
        this.is_reserved = is_reserved;
    }

    public Room(int floor, int nbr_places, float price_per_day) {
        this.floor = floor;
        this.nbr_places = nbr_places;
        this.price_per_day = price_per_day;
    }

    public Room(int nbr_places, float price_per_day) {
        this.nbr_places = nbr_places;
        this.price_per_day = price_per_day;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
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

    public boolean getIs_reserved() {
        return is_reserved;
    }

    public void setIs_reserved(boolean is_reserved) {
        this.is_reserved = is_reserved;
    }
}
