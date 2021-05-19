package com.tp6;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey
    private int numPro;
    private String designation;
    @ColumnInfo(name="prix_unitaire")
    private double prix;

    public Product() {
    }

    public Product(int numPro, String designation, double prix) {
        this.numPro = numPro;
        this.designation = designation;
        this.prix = prix;
    }

    public int getNumPro() {
        return numPro;
    }

    public void setNumPro(int numPro) {
        this.numPro = numPro;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
