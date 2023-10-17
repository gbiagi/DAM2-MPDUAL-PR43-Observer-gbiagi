package com.project;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Magatzem {
    private ArrayList<PR450Producte> productes;
    private int capacitat = 10;

    public PR450Magatzem(){
    }
    private PropertyChangeSupport listaObservers = new PropertyChangeSupport(this);



    public PR450Producte getProducte(int id) {
        return productes.get(id);
    }

    public void addProducte(PR450Producte producte) {
        productes.add(producte);
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }
}
