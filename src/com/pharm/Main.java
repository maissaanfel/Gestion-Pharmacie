package com.pharm;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ArrayList<MedicamentEnStock> medsEx = new ArrayList<MedicamentEnStock>(); // repertoire des medicaments externes
        ArrayList<MedicamentInterne> medsIn = new ArrayList<MedicamentInterne>(); // repertoire des medicaments internes
        ArrayList<Parapharmaceutique> para = new ArrayList<Parapharmaceutique>(); // repertoire des produits parapharmaceutiques

        ArrayList<String> commandes = new ArrayList<String>(); //Registre des commandes (Clients-fournisseurs).
        ArrayList<String> commandesM = new ArrayList<String>(); //Registre des commandes (Medecins Conventionnes).
        ArrayList<Ordannance> ordRep = new ArrayList<Ordannance>(); // Ordonnances en cours de traitement

        ArrayList<ClientPermanent> clientsP = new ArrayList<ClientPermanent>(); // le registre des clients permanents
        ArrayList<MedecinConventionne> medecins = new ArrayList<MedecinConventionne>(); //le registre des medecins convontionne




        while(true){
            System.out.println("Choisissez : \n1- Achat Client Avec Ordonnance\n2- Achat Client Sans Ordonnance (Produits parapharmaceutiques Ou Medicaments Sans Ordonnance)\n" +
                    "3- Achat Medecin\n4- Ajouter Medicament En Stock\n5- Ajouter Medicament Interne\n6- Ajouter Client Permanent\n7- Ajouter Medecin Conventionne\n");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1://Client Avec Ordonnance
                    System.out.println("Achat Avec Ordonnance !\n");
                    Ordannance ord = Util.creationOrdonnance(); //On saisi l'ordonnance.
                    ordRep.add(ord);//Ajouter l'ordonnance au repertoire.
                    //On cherche si le client est permanent ou pas.
                    int k;
                    if ((k = Util.chercherClientPermanent(ord.getNomClient(), ord.getPrenomClient(), ord.getAgeClient(), clientsP)) != -1) {
                        //Cas Client Permanent Avec Ordonnance
                        //Achat ==>
                        System.out.println("Ce client est permanent !\n");
                        float facture = 0;
                        facture = Util.facturation(medsEx, medsIn, clientsP, ord, commandes, facture, k);
                        System.out.println("Le montant total à payer est : " + facture + " DA");
                    } else {
                        //Client Lambda Avec Ordonnance
                        float facture = 0;
                        facture = Util.facturation(medsEx, medsIn, clientsP, ord, commandes, facture, k);
                        System.out.println("Le montant total à payer est : " + facture + " DA");
                    }
                    break;
                case 2:
                    //Achat sans ordonnance
                    System.out.println("Achat Sans Ordonnance !\n");
                    // Produit parapharmaceutique
                    float facture1 = 0;
                    facture1 = Util.facturationParapharmaceutique(para, commandes, facture1);
                    //Medicament sans ordonnance
                    float facture2 = 0;
                    facture2 = Util.facturationSansOrdonnance(medsEx, commandes, facture2);
                    System.out.println("Le montant total à payer est : " + (facture1 + facture2) + " DA");
                    break;
                case 3:
                    // Commande medecin conv
                    System.out.println("Nom medecin : ");
                    String nom = s.nextLine();
                    System.out.println("Prenom medecin : ");
                    String prenom = s.nextLine();
                    System.out.println("Specialite medecin : ");
                    String spec = s.nextLine();
                    int j;
                    if ((j = Util.charecherMedecinConv(nom, prenom, spec, medecins)) != -1){
                        medecins.get(j).commandeMedecin(commandesM);
                    }
                    break;
                case 4:
                    //Ajouter medicament en stock au repertoire
                    System.out.println("Ajouter un medicament en stock !\n");
                    Util.ajouterMedicamentEnStock(medsEx);
                    System.out.println("Medicament ajouté avec succés !\n");
                    break;
                case 5:
                    //Ajouter medicament interne au repertoire
                    System.out.println("Ajouter un medicament interne !\n");
                    Util.ajouterMedicamentInterne(medsIn);
                    System.out.println("Medicament ajouté avec succés !\n");
                    break;
                case 6:
                    //Ajouter un client permanant
                    System.out.println("Ajouter un client permanant !\n");
                    Util.ajouterClientPermanent(clientsP);
                    break;
                case 7:
                    //Ajouter medecin conventionne
                    System.out.println("Ajouter un medecin conventionné\n");
                    Util.ajouterMedecinConv(medecins);
                    break;
            }
        }


    }


}
