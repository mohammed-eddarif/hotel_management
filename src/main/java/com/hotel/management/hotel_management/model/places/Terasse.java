package com.hotel.management.hotel_management.model.places;

public class Terasse {

    private int terasse_id;
    private int nbr_places;
    private float price;

    public Terasse(int terasse_id, int nbr_places, float price) {
        this.terasse_id = terasse_id;
        this.nbr_places = nbr_places;
        this.price = price;
    }

    public Terasse(int nbr_places, float price) {
        this.nbr_places = nbr_places;
        this.price = price;
    }

    public int getTerasse_id() {
        return terasse_id;
    }

    public void setTable_id(int terasse_id) {
        this.terasse_id = terasse_id;
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
                "terasse_id=" + terasse_id +
                ", nbr_places=" + nbr_places +
                ", price=" + price +
                '}';
    }
}
