package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Magatzem {
    private ArrayList<PR450Producte> productes;
    private int capacitat = 10;

    public PR450Magatzem(){
        this.productes = new ArrayList<>();
    }
    private PropertyChangeSupport listaObservers = new PropertyChangeSupport(this);



    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }
    public void addProducte(PR450Producte producte) {
        if (productes.size() < capacitat) {
            productes.add(producte);
            capacitat--;
            listaObservers.firePropertyChange("magatzemAdd", null, producte);
        }
    }

    public void removeProducte(int idProducte) {
        for (int i = 0; i < productes.size(); i++) {
            PR450Producte producte = productes.get(i);
            if (producte.getId() == idProducte) {
                capacitat++;
                productes.remove(i);
                listaObservers.firePropertyChange("magatzemRemove", producte, null);
                listaObservers.firePropertyChange("magatzemEntrega", null, producte);
                break;
            }
        }
    }
    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listaObservers.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        listaObservers.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Productes al magatzem: " + this.getProductes().toString();
    }
}
