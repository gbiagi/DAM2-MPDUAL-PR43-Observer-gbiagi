package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PR450Producte {
    private int id;
    private String nom;
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);

    public PR450Producte(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldID = this.id;
        this.id = id;
        llistaObservers.firePropertyChange("Id", oldID, id);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        llistaObservers.firePropertyChange("Nom", oldNom, nom);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return id + ": " + nom;
    }
}
