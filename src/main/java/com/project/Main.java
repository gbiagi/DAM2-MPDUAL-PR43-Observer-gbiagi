package com.project;

public class Main {
    public static void main (String[] args) {


        PR450Producte p0 = new PR450Producte(0, "Llibre");
        PR450Producte p1 = new PR450Producte(1, "Llapis");
        PR450Producte p2 = new PR450Producte(2, "Rotulador");
        PR450Producte p3 = new PR450Producte(3, "Carpeta");
        PR450Producte p4 = new PR450Producte(4, "Motxilla");


        PR450Magatzem magatzem = new PR450Magatzem();
        PR450Entregues entregues = new PR450Entregues();

        // Aquí afegir els property listeners adequats
        p0.addPropertyChangeListener(evt -> {
            System.out.println("Producte ha canviat el nom de '" + evt.getOldValue() + "' a '" + evt.getNewValue() + "'");
        });
        p1.addPropertyChangeListener(evt -> {
            System.out.println("Producte ha canviat el nom de '" + evt.getOldValue() + "' a '" + evt.getNewValue() + "'");
        });

        magatzem.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("magatzemAdd")) {
                System.out.println("S'ha afegit el producte amb id " + ((PR450Producte) evt.getNewValue()).getId() +
                        " al magatzem, capacitat: " + magatzem.getCapacitat());
            } else if (evt.getPropertyName().equals("magatzemRemove")) {
                System.out.println("S'ha esborrat el producte amb id " + ((PR450Producte) evt.getOldValue()).getId() +
                        " del magatzem, capacitat: " + magatzem.getCapacitat());
            } else if (evt.getPropertyName().equals("magatzemEntrega")) {
                System.out.println("S'ha mogut el producte amb id " + ((PR450Producte) evt.getNewValue()).getId() +
                        " del magatzem cap a entregues");
                entregues.addProducte((PR450Producte) evt.getNewValue());
            }
        });

        entregues.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("entreguesAdd")) {
                System.out.println("S'ha afegit el producte amb id " + ((PR450Producte) evt.getNewValue()).getId() +
                        " a la llista d'entregues");
            } else if (evt.getPropertyName().equals("entreguesRemove")) {
                System.out.println("S'ha entregat el producte amb id " + ((PR450Producte) evt.getOldValue()).getId());
            }
        });

        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Boli");


        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);

        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(4);

        entregues.removeProducte(2);
        entregues.removeProducte(3);


        System.out.println(magatzem);
        System.out.println(entregues);


    }
}
