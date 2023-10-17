package com.project;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Entregues {
    private ArrayList<PR450Producte> productes;

    public PR450Entregues() {}

    private PropertyChangeSupport listaObservers = new PropertyChangeSupport(this);

    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }

    public void setProductes(ArrayList<PR450Producte> productes) {
        this.productes = productes;
    }
}
