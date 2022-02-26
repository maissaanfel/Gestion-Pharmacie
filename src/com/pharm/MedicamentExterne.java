package com.pharm;

public abstract class MedicamentExterne extends Medicament {
    private String nomFirme;

    public MedicamentExterne(String nomMed, String type, String modeDePrise, boolean avecOrdonnance, boolean remboursable, float tauxRemboursement, String nomFirme) {
        super(nomMed, type, modeDePrise, avecOrdonnance, remboursable, tauxRemboursement);
        this.nomFirme = nomFirme;
    }

    public String getNomFirme() {
        return nomFirme;
    }

}
