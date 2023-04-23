package com.hotel.management.hotel_management.model.places;

public class NightClub {
    private int night_club_id;
    private int nbr_places;
    private float price;

    public NightClub(int night_club_id, int nbr_places, float price) {
        this.night_club_id = night_club_id;
        this.nbr_places = nbr_places;
        this.price = price;
    }

    public NightClub(int nbr_places, float price) {
        this.nbr_places = nbr_places;
        this.price = price;
    }

    public int getNight_club_id() {
        return night_club_id;
    }

    public void setNight_club_id(int night_club_id) {
        this.night_club_id = night_club_id;
    }

    public int getNbr_places() {
        return nbr_places;
    }

    public void setNbr_places(int nbr_places) {
        this.nbr_places = nbr_places;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Table{" +
                "night_club_id=" + night_club_id +
                ", nbr_places=" + nbr_places +
                ", price=" + price +
                '}';
    }
}
