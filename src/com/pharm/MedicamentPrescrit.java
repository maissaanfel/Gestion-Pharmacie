package com.pharm;

public class MedicamentPrescrit {
    private String nomMed;
    private int qte;
    private int dureeTraitement;

    public MedicamentPrescrit(String nomMed, int qte, int dureeTraitement) {
        this.nomMed = nomMed;
        this.qte = qte;
        this.dureeTraitement = dureeTraitement;
    }

    public int getDureeTraitement() {
        return dureeTraitement;
    }

    public String getNomMed() {
        return nomMed;
    }

    public int getQte() {
        return qte;
    }
}
