package com.pharm;

import java.util.ArrayList;
import java.util.Scanner;

public class MedecinConventionne {
    private String nomMedecin;
    private String prenomMedecin;
    private String specialite;
    private String adresse;

    public MedecinConventionne(String nomMedecin, String prenomMedecin, String specialite, String adresse) {
        this.nomMedecin = nomMedecin;
        this.prenomMedecin = prenomMedecin;
        this.specialite = specialite;
        this.adresse = adresse;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public String getPrenomMedecin() {
        return prenomMedecin;
    }

    public String getSpecialite() {
        return specialite;
    }


    public void commandeMedecin(ArrayList<String> commandesM){
        Scanner s = new Scanner(System.in);
        System.out.println("\nCombien de produit voulez-vous commandez : ");
        int n = s.nextInt();
        s.nextLine();
        String commande = "Medecin : " + nomMedecin + " " + prenomMedecin + " \n";
        for(int i = 0; i < n; i++){
            System.out.println("\nDonnez le nom du produit :");
            String nom = s.nextLine();
            System.out.println("\nDonnez la quantite voulu :");
            int qte = s.nextInt();
            s.nextLine();
            commande += nom + " " + qte + "\n";
        }
        commandesM.add(commande);
        System.out.println("La commandes a été enregistré");
    }
}


