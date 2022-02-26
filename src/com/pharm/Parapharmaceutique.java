package com.pharm;
import java.time.LocalDate;
import java.util.ArrayList;

public class Parapharmaceutique implements Calcul{

    private String nomProduit;
    private int numLot;
    private LocalDate date_exp;
    private float prix;
    private int qte;
    private int seuil;
    private String nomFournisseur;

    public Parapharmaceutique(String nomProduit, int numLot, LocalDate date_exp, float prix, int seuil, String nom_fournisseur) {
        this.nomProduit = nomProduit;
        this.numLot = numLot;
        this.date_exp = date_exp;
        this.prix = prix;
        this.seuil = seuil;
        this.nomFournisseur = nom_fournisseur;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public LocalDate getDate_exp() {
        return date_exp;
    }

    public int getQte() {
        return qte;
    }

    @Override
    public void miseAjourduStock(int qte) {
        this.qte -= qte;
    }

    @Override
    public boolean seuilAtteint() {
        if(qte <= seuil){
            return true;
        }
        return false;
    }

    @Override
    public void envoyerCommande(ArrayList<String> commandes) {
        commandes.add("Medicament ==> " + nomProduit + " Quantite ==> " + (seuil * 10) + " Fournisseur ==> " + nomFournisseur);
    }

    @Override
    public float vendre(int qte, boolean affiliationClient, boolean achatAvecOrdonnance, ArrayList<String> commandes) {
        int facture = 0;
        facture += qte * prix;
        miseAjourduStock(qte);//On mis le stock a jour
        if(seuilAtteint()){//On teste si le seuil est atteint
            System.out.println("Rupture du stock du produit : '" + nomProduit + "', Le fournisseur : '" + nomFournisseur + "' est contacté via la commande numero : '" + (commandes.size()+1) +"'\n" );
            envoyerCommande(commandes);
        }
        return facture;
    }
}
