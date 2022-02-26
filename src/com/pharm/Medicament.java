package com.pharm;

public abstract class Medicament {
    private String nomMed;
    private String type;
    private String modeDePrise;
    private boolean avecOrdonnance;
    private boolean remboursable;
    private float tauxRemboursement;


    public Medicament(String nomMed, String type, String modeDePrise, boolean avecOrdonnance, boolean remboursable, float tauxRemboursement) {
        this.nomMed = nomMed;
        this.type = type;
        this.modeDePrise = modeDePrise;
        this.avecOrdonnance = avecOrdonnance;
        this.remboursable = remboursable;
        if(remboursable){
            this.tauxRemboursement = tauxRemboursement;
        }else{
            this.tauxRemboursement = 0;//Si le medicament n'est pas remboursable cad que le taux = 0 cela nous permettra d'eviter les erreurs.
        }

    }

    public float getTauxRemboursement() {
        return tauxRemboursement;
    }

    public String getNomMed() {
        return nomMed;
    }

    public boolean isAvecOrdonnance() {
        return avecOrdonnance;
    }

    public abstract float prixApresRemboursement();
}
