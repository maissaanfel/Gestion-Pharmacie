package com.pharm;
import java.time.LocalDate;

import java.util.ArrayList;

public class MedicamentEnStock extends MedicamentExterne implements Calcul {
    private int qte;
    private int numLot;
    private LocalDate date_exp;
    private float prix;
    private int seuil;


    public MedicamentEnStock(String nomMed, String type, String modeDePrise, boolean avecOrdonnance, boolean remboursable, String nomFirme, float tauxRemboursement, int qte, int numLot, LocalDate date_exp, float prix, int seuil) {
        super(nomMed, type, modeDePrise, avecOrdonnance, remboursable,tauxRemboursement, nomFirme);
        this.qte = qte;
        this.numLot = numLot;
        this.date_exp = date_exp;
        this.prix = prix;
        this.seuil = seuil;
    }

    public int getQte() {
        return qte;
    }

    public LocalDate getDate_exp() {
        return date_exp;
    }


    @Override
    public float prixApresRemboursement() {
        return (prix*((100-getTauxRemboursement())/100));
    }

    @Override
    public void miseAjourduStock(int qte) {
        this.qte -=qte;
    }

    @Override
    public boolean seuilAtteint() {
        if(qte <= seuil){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void envoyerCommande(ArrayList<String> commandes) {
        commandes.add("Medicament ==> " + getNomMed() + " Quantite ==> " + (seuil * 10) + " Fournisseur ==> " + getNomFirme());
    }

    @Override
    public float vendre(int qte, boolean affiliationClient, boolean clientAvecOrdonnance, ArrayList<String> commandes) {
        float facture = 0;
        if(clientAvecOrdonnance){
            if(affiliationClient){
                facture += qte * prixApresRemboursement();
            }else{
                facture += qte * prix;
            }
            miseAjourduStock(qte);//On mis le stock a jour
            if(seuilAtteint()){ //On teste si le suil est atteint
                System.out.println("Rupture du stock du medicament : '" + getNomMed() + "', Le fournisseur : '" + getNomFirme() + "' est contacté via la commande numero : '" + (commandes.size()+1) +"'\n" );
                envoyerCommande(commandes);
                //commandes.clear();
            }
        }else{
            if(isAvecOrdonnance()){
                System.out.println("Ce medicament est uniquement vendu avec ordonnance\n");
            }else {
                facture += qte * prix;
                miseAjourduStock(qte);
            }
        }

        return facture;
    }
}
