package com.pharm;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MedicamentInterne extends Medicament {
    private ArrayList<CompositionDosage> composition;
    private float prix;

    public MedicamentInterne(String nomMed, String type, String modeDePrise, boolean remboursable, float tauxRemboursement, ArrayList<CompositionDosage> composition, float prix) {
        super(nomMed, type, modeDePrise, true, remboursable, tauxRemboursement);
        this.composition = composition;
        this.prix = prix;
    }

    public float venteInterne(int qte, boolean affiliationClient, boolean achatAvecOrdonnance){
        float facture = 0;
        if(achatAvecOrdonnance){
            if(affiliationClient){
                facture += qte * prixApresRemboursement();
            }else{
                facture += qte * prix;
            }
        }else{
            System.out.println("Les medicaments internes sont vandus uniquement avec ordonnance\n");
        }

        return facture;
    }

    @Override
    public float prixApresRemboursement(){
        return (prix*((100-getTauxRemboursement())/100));
    }



}
