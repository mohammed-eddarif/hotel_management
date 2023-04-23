package com.hotel.management.hotel_management.model.places;

public class Table {

    private int table_id;
    private int nbr_places;
    private float price;

    public Table(int table_id, int nbr_places, float price) {
        this.table_id = table_id;
        this.nbr_places = nbr_places;
        this.price = price;
    }

    public Table(int nbr_places, float price) {
        this.nbr_places = nbr_places;
        this.price = price;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
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
                "table_id=" + table_id +
                ", nbr_places=" + nbr_places +
                ", price=" + price +
                '}';
    }
}
