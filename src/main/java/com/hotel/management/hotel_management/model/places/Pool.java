package com.hotel.management.hotel_management.model.places;

public class Pool {

    private int pool_id;
    private int nbr_places;
    private float price;

    public Pool(int pool_id, int nbr_places, float price) {
        this.pool_id = pool_id;
        this.nbr_places = nbr_places;
        this.price = price;
    }

    public Pool(int nbr_places, float price) {
        this.nbr_places = nbr_places;
        this.price = price;
    }

    public int getPool_id() {
        return pool_id;
    }

    public void setPool_id(int pool_id) {
        this.pool_id = pool_id;
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
                "pool_id=" + pool_id +
                ", nbr_places=" + nbr_places +
                ", price=" + price +
                '}';
    }
}
