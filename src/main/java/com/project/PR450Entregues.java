package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Entregues {
    private ArrayList<PR450Producte> productes;
    private PropertyChangeSupport listaObservers = new PropertyChangeSupport(this);

    public PR450Entregues() {
        this.productes = new ArrayList<>();
    }

    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }
    public void addProducte(PR450Producte producte) {
        productes.add(producte);
        listaObservers.firePropertyChange("entreguesAdd", null, producte);
    }
    public void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            PR450Producte producte = productes.get(i);
            if (producte.getId() == id) {
                productes.remove(i);
                listaObservers.firePropertyChange("entreguesRemove", producte, null);
                break;
            }
        }
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listaObservers.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        listaObservers.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Productes per entregar: " + this.getProductes().toString();
    }
}
