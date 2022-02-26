package com.pharm;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

//On met dans cette classe les fonctions et les methodes qu'on va utiliser dans le main.

public class Util {

    //Cette fonction nous permettra de saisir un ou plusieurs medicament prescrit(dans l'ordonnance)
    private static void inputMedicamentPrescrit(ArrayList<MedicamentPrescrit> medP) {
        Scanner s = new Scanner(System.in);
        System.out.println("Combien de medicament prescrit avez vous dans votre ordonnance ?\n");
        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("\nEntrer les informations du medicament numero " + (i+1) + " : ");
            System.out.println("\nNom de medicament : ");
            String nomMed = s.nextLine();
            System.out.println("\nQuantite voulu : ");
            int qte = s.nextInt();
            s.nextLine();
            System.out.println("\nDuree de traitement en jours : ");
            int dureeTraitement = s.nextInt();
            s.nextLine();
            MedicamentPrescrit medpres = new MedicamentPrescrit(nomMed, qte, dureeTraitement);
            medP.add(medpres);
        }
    }

    //Cette fonction nous permettra de saisir une ordonnance
    public static Ordannance creationOrdonnance(){
        Scanner s = new Scanner(System.in);
        System.out.println("Veuillez Entrer Votre Ordonnance");
        System.out.println("\nVotre Nom : ");
        String nomClient = s.nextLine();
        System.out.println("\nVotre Prenom : ");
        String prenomClient = s.nextLine();
        System.out.println("\nVotre age : ");
        String ageClient = s.nextLine();
        System.out.println("\nNom Medecin : ");
        String nomMedecin = s.nextLine();
        System.out.println("\nPrenom Medecin : ");
        String prenomMedecin = s.nextLine();
        System.out.println("\nSpécialité Medecin : ");
        String specialiteMedecin = s.nextLine();
        System.out.println("\nAdreesse Medecin : ");
        String adresseMedecin = s.nextLine();
        System.out.println("\nLa Date (en chiffres) ==>  ");
        System.out.println("Donnez le jour : ");
        int jour = s.nextInt();
        s.nextLine();
        System.out.println("Donnez le mois : ");
        int mois = s.nextInt();
        s.nextLine();
        System.out.println("Donnez l'Annee : ");
        int year = s.nextInt();
        s.nextLine();
        LocalDate date = LocalDate.of(year, mois, jour);

        ArrayList<MedicamentPrescrit> medP = new ArrayList<MedicamentPrescrit>();
        inputMedicamentPrescrit(medP);//Saisir les medicament prescrits.
        Ordannance ord = new Ordannance(nomClient, prenomClient, ageClient, nomMedecin, prenomMedecin, specialiteMedecin, adresseMedecin, date, medP);

        return ord;
    }
    // Cette fonction nous permettra de chercher si un client est permanent dans notre pharmacie ou pas et retouner sa position dans notre repertoire
    public static int chercherClientPermanent(String nomClient, String prenomClient, String ageClient, ArrayList<ClientPermanent> ClientP){
        for(int i = 0; i < ClientP.size(); i++){
            if (nomClient.equals(ClientP.get(i).getNomClient()) &&  prenomClient.equals(ClientP.get(i).getPrenomClient()) && ageClient.equals(ClientP.get(i).getAgeClient())){
                return i;
            }
        }
        return -1;
    }

    // Cette fonctions nous permettera de chercher si un medecin est conventionne ou non et retourner sa position
    public static int charecherMedecinConv(String nomMedecin, String prenomMedecin, String specialite, ArrayList<MedecinConventionne> medecins){
        for (int i =0; i< medecins.size(); i++){
            if (nomMedecin.equals(medecins.get(i).getNomMedecin()) &&  prenomMedecin.equals(medecins.get(i).getPrenomMedecin()) && specialite.equals(medecins.get(i).getSpecialite())){
                return i;
            }
        }
        return -1;
    }

    // Chercher si un medicament interne existe dans notre system et retourner sa position dans le repertoire.
    private static int chercherDansInterne(ArrayList<MedicamentInterne> medsIn, String nomMed){
        for(int i = 0; i < medsIn.size(); i++){
            if(medsIn.get(i).getNomMed().equals(nomMed)){
                return i;
            }
        }
        return -1;
    }

    // Chercher si un medicament externe existe dans notre system et retourner sa position dans le repertoire.
    private static int chercherDansExterne(ArrayList<MedicamentEnStock> medsEx, String nomMed, int qte){
        for(int i = 0; i < medsEx.size(); i++){
            if(medsEx.get(i).getNomMed().equals(nomMed) ) {
                return i;
            }
        }
        return -1;
    }

    // Chercher si un produit parapharmaceutique existe dans notre system et retourner sa position dans le repertoire.
    private static int chercherDansParapharmaceutique(ArrayList<Parapharmaceutique> para, String nomProduit){
        for(int i = 0; i<para.size(); i++){
            if(para.get(i).getNomProduit().equals(nomProduit)){
                return i;
            }
        }
        return -1;
    }

    //Cette fonction nous permettra de saisir les maladies chroniques d'un client(lors de la creation d'un client permanent)
    private static ArrayList<String> inputMaladiesChroniques(){
        Scanner s = new Scanner(System.in);
        System.out.println("Combien De Maladies Chronique Avez-Vous ? (Si vous n'avez pas mettez 0) : ");
        int nb = s.nextInt();
        s.nextLine();
        ArrayList<String> listM = new ArrayList<String>();
        for(int i = 0 ; i < nb; i++){
            System.out.println("\nEntrez le nom de la maladie numero " + i+1 + " : ");
            String maladie = s.nextLine();
            listM.add(maladie);
        }

        return listM;
    }

    public static void ajouterClientPermanent(ArrayList<ClientPermanent> clientsP){
        Scanner s = new Scanner(System.in);
        System.out.println("\nNom Client : ");
        String nomClient = s.nextLine();
        System.out.println("\nPrenom Client : ");
        String prenomClient = s.nextLine();
        System.out.println("\nAge Client");
        String ageClient = s.nextLine();
        System.out.println("\nAffiliation ?\nOui ==> 1\nNon ==> 2");
        int choice3 = s.nextInt();
        s.nextLine();
        switch(choice3){
            case 1:
                System.out.println("\nNSS :");
                int NSS = s.nextInt();
                s.nextLine();
                ArrayList<String> listMaladies = inputMaladiesChroniques();
                ClientPermanent client = new ClientPermanent(nomClient, prenomClient, ageClient, NSS, true, listMaladies);
                clientsP.add(client);//Ajouter le nouveau client permanent au repertoire
                System.out.println("Vous êtes devenu permanent !\n");
                break;
            case 2:
                ArrayList<String> listMaladies2 = inputMaladiesChroniques();
                ClientPermanent client2 = new ClientPermanent(nomClient, prenomClient, ageClient, 0, false, listMaladies2);
                clientsP.add(client2);//Ajouter le nouveau client permanent au repertoire
                System.out.println("Vous êtes devenu permanent !\n");
                break;
        }
    }

    public static void ajouterMedecinConv(ArrayList<MedecinConventionne> medecins){
        Scanner s = new Scanner(System.in);
        System.out.println("\nLe nom du medecin : ");
        String nom = s.nextLine();
        System.out.println("\nLe prenom du medecin : ");
        String prenom = s.nextLine();
        System.out.println("\nLa specialité du medecin : ");
        String spec = s.nextLine();
        System.out.println("\nL'adresse' du medecin : ");
        String adr = s.nextLine();
        MedecinConventionne m = new MedecinConventionne(nom, prenom, spec, adr);
        medecins.add(m);
        System.out.println("Medecin Ajouté vec Succés\n");
    }

    public static void ajouterMedicamentEnStock(ArrayList<MedicamentEnStock> medsEx){
        Scanner s = new Scanner(System.in);
        System.out.println("\nLe nom de medicament à ajouter dans le stock : ");
        String nomMed = s.nextLine();
        System.out.println("\nLe type de medicament : ");
        String type = s.nextLine();
        System.out.println("\nLe mode de prise de medicament : ");
        String modeDePrise = s.nextLine();
        System.out.println("\nCe medicament se vend avec ordonnance ou pas ? : \n1- oui\n2- non\n");
        boolean avecOrdonnance;
        int choice3 = s.nextInt();
        if(choice3 == 1){
            avecOrdonnance = true;
        }else {
            avecOrdonnance = false;
        }
        System.out.println("\nCe medicament est remboursable ? : \n1- oui\n2- non\n");
        boolean remboursable;
        choice3 = s.nextInt();
        if(choice3 == 1){
            remboursable = true;
        }else {
            remboursable = false;
        }
        float tauxDeRemboursement = 0;
        if (remboursable){
            System.out.println("\nTaux de remboursement : ");
            tauxDeRemboursement = s.nextFloat();
            s.nextLine();
        }
        System.out.println("\nNom de la firme : ");
        String nomFirme = s.nextLine();
        System.out.println("\nQuantite : ");
        int qte = s.nextInt();
        s.nextLine();
        System.out.println("\nNum de lot : ");
        int lot = s.nextInt();
        s.nextLine();
        System.out.println("\nSeuil : ");
        int seuil = s.nextInt();
        s.nextLine();
        System.out.println("\nPrix unitaire : ");
        int prix = s.nextInt();
        s.nextLine();
        System.out.println("\nDate d'expiration (en chiffre) : \nJour :");
        int jour = s.nextInt();
        s.nextLine();
        System.out.println("\nMois :");
        int mois = s.nextInt();
        s.nextLine();
        System.out.println("\nAnnee :");
        int year = s.nextInt();
        s.nextLine();
        MedicamentEnStock medic = new MedicamentEnStock(nomMed, type, modeDePrise, avecOrdonnance, remboursable, nomFirme,tauxDeRemboursement, qte, lot, LocalDate.of(year, mois, jour), prix, seuil);
        medsEx.add(medic);
    }

    public static void ajouterMedicamentInterne(ArrayList<MedicamentInterne> medsIn){
        Scanner s = new Scanner(System.in);
        System.out.println("\nLe nom de medicament à ajouter dans le repertoire des medicaments internes : ");
        String nomMed = s.nextLine();
        System.out.println("\nLe type de medicament : ");
        String type = s.nextLine();
        System.out.println("\nLe mode de prise de medicament : ");
        String modeDePrise = s.nextLine();
        System.out.println("\nCe medicament est remboursable ? : \n1- oui\n2- non\n");
        boolean remboursable;
        int choice = s.nextInt();
        if(choice == 1){
            remboursable = true;
        }else {
            remboursable = false;
        }
        float tauxDeRemboursement = 0;
        if (remboursable){
            System.out.println("\nTaux de remboursement : ");
            tauxDeRemboursement = s.nextFloat();
            s.nextLine();
        }
        System.out.println("\nPrix unitaire : ");
        int prix = s.nextInt();
        s.nextLine();
        System.out.println("\nDe combien de matières premières se compose ce medicament ?");
        int n = s.nextInt();
        s.nextLine();
        ArrayList<CompositionDosage> composition = new ArrayList<CompositionDosage>();
        for(int i =0; i < n ;i++){
            System.out.println("\nDonner la matière num " + (i+1) + " : ");
            String matiere = s.nextLine();
            System.out.println("\nDonner le dosage : ");
            float dosage = s.nextFloat();
            s.nextLine();
            CompositionDosage c = new CompositionDosage(matiere, dosage);
            composition.add(c);
        }

        MedicamentInterne medic = new MedicamentInterne(nomMed, type, modeDePrise, remboursable, tauxDeRemboursement, composition, prix);
        medsIn.add(medic);
    }

    ////////////////////////////////////////////////////////////// Facturation //////////////////////////////////////////////////////////////////////

    //Achat Avec Odonnance d'un client Permanant ou Lambda
    public static float facturation(ArrayList<MedicamentEnStock> medsEx, ArrayList<MedicamentInterne> medsIn, ArrayList<ClientPermanent> clientsP,Ordannance ord, ArrayList<String> commandes,float facture, int k){
        Scanner s = new Scanner(System.in);
        boolean affiliationLambda = false;
        int NSS = 0;
        boolean demander = false;
        if (k == -1){ //si k == -1 ==> Cas Client Lambda Avec Ordonnance ==> on saisie les informations avec rapport a la securite sociale de ce client.
            System.out.println("Client Affilié ?\nOui ==> 1\nNon ==> 2");
            int choice3 = s.nextInt();
            s.nextLine();
            switch(choice3){
                case 1:
                    affiliationLambda = true;
                    System.out.println("NSS\n");
                    NSS = s.nextInt();
                    s.nextLine();
                    break;
                case 2:
                    affiliationLambda = false;
                    System.out.println("Vous allez acheter sans remboursement\n");
                    break;
                default:
                    affiliationLambda = false;
                    break;
            }
        }
        //On boucle sur les medicaments prescrit de l'ordonnance.
        for (int i = 0; i < ord.getMedP().size(); i++) {
            String name = ord.getMedP().get(i).getNomMed();
            int qte = ord.getMedP().get(i).getQte();
            int j;
            if ((j = chercherDansInterne(medsIn, name)) != -1) {//si le medicament est disponible en interne
                if(k != -1){// Cas client permanent
                    facture += medsIn.get(j).venteInterne(qte, clientsP.get(k).isAffiliation(), true);
                }else {// Cas client lambda
                    facture += medsIn.get(j).venteInterne(qte, affiliationLambda, true);
                }


            } else if ((j = chercherDansExterne(medsEx, name, qte)) != -1) {//Si le medicament est disponible en stock
                boolean expired = (LocalDate.now().plusDays(ord.getMedP().get(i).getDureeTraitement()).isBefore(medsEx.get(j).getDate_exp()));//Si la date d'expiration depasse la duree du traitement.
                if (qte <= medsEx.get(j).getQte() && !expired) { // Si quantite suffisante est non expired
                    if(k != -1){ // Cas client permanent
                        facture += medsEx.get(j).vendre(qte, clientsP.get(k).isAffiliation(),true, commandes);
                    }else { // Cas client Lambda
                        facture += medsEx.get(j).vendre(qte, affiliationLambda,true, commandes);
                    }

                } else if(qte > medsEx.get(j).getQte() && !expired){ // Si Quantite non suffisante on demande si le client veut faire un achat partiel
                    System.out.println("Le Medicament " + name + " Disponible mais avec quantite insuffisante Vous Avez demande " + qte + " Mais que " + medsEx.get(j).getQte() + " sont disponible" +"\nVoulez vous faire un achat partiel (prendre que la quantite disponible) ?\n1- Oui\n2- Non\n");
                    int choice5 = s.nextInt();
                    s.nextLine();
                    switch (choice5) {
                        case 1: //Acceptation d'un achat partiel.
                            if (k != -1){ // Cas client permanet
                                facture += medsEx.get(j).vendre(medsEx.get(j).getQte(), clientsP.get(k).isAffiliation(), true, commandes);
                            }else {// cas client Lambda
                                facture += medsEx.get(j).vendre(medsEx.get(j).getQte(), affiliationLambda, true, commandes);
                            }
                            break;
                        case 2: //Rufus d'un achat partiel
                            if (k != -1){ //Si le client permanent refuse l'achat partiel il peut faire une commande.
                                System.out.println("Voulez vous faire une commande pour ce medicament ?\n1- Oui\n2- Non\n");
                                int choice6 = s.nextInt();
                                s.nextLine();
                                switch (choice6) {
                                    case 1:
                                        commandes.add("Medicament : " + name + " Quantite : " + qte + " Fournisseur : " + medsEx.get(j).getNomFirme());
                                        System.out.println("\nCommande faite avec succes!");
                                        break;
                                    case 2:
                                        System.out.println("\nVous avez decide de ne pas achete ce medicament ==> " + name);
                                        break;
                                }
                            }else if(k == -1 && !demander){ // Si le client lambda refuse l'achat partiel on lui demande si il veut devenir permanent pour passer une commande.
                                //la variable "demander" est un booleen pour assurer qu'on demande le changement vers permanent qu'une seule fois (pas dans chaque iteration).
                                System.out.println("Voulez-vous devenir un client permanent dans notre pharmacie pour passer une commande ?\nOui ==> 1\nNon ==> 2");
                                demander = true;
                                int choice1 = s.nextInt();
                                s.nextLine();
                                switch(choice1){
                                    case 1:
                                        ArrayList<String> maladies = inputMaladiesChroniques(); // On a toutes les informations du client sauf les maladies chroniques.
                                        ClientPermanent client = new ClientPermanent(ord.getNomClient(), ord.getPrenomClient(), ord.getAgeClient(), NSS, affiliationLambda, maladies);
                                        clientsP.add(client);
                                        k = clientsP.size()-1; //On change le k pour que dans les prochaines iterations (l'achat du reste des medicaments prescrits) le client sera traité comme permanent.
                                        commandes.add("Medicament ==> " + name + " Quantite ==> " + qte + " Fournisseur ==> " + medsEx.get(j).getNomFirme());
                                        System.out.println("\nCommande faite avec succes!");
                                        break;
                                    case 2:
                                        System.out.println("\nVous avez decidé de ne pas devenir permanent, vous ne pouvez pas faire des commandes");
                                }
                            }else if(k == -1 && demander){
                                System.out.println("\nVous avez decidé de ne pas acheté ce medicament ==> " + name);
                            }

                            break;

                    }
                }else{ //Cas si le medicament est expiré
                    System.out.println("Ce Medicament est non disponible pour le moment : " + name + " \n");
                }
            } else { //Cas si medicament n'existe pas dans les repertoires internes et externe
                System.out.println("\nCe Medicament est non disponible : " + name + " \n");
            }

        }
        return facture;
    }

    //Produits Parapharmaceutiques
    public static float facturationParapharmaceutique(ArrayList<Parapharmaceutique> para, ArrayList<String> commandes,float facture){
        Scanner s = new Scanner(System.in);
        //Choisir combien de medicament il veut acheter, et le type (medic ou parapharmaceutique)
        System.out.println("Combien de produits pharmaceutique voulez-vous acheter ? repondez par '0' si vous ne souhaitez pas acheter des produits parapharmaceutiques \n");
        int nb = s.nextInt();
        s.nextLine();
        for(int i = 0;i < nb;i++){
            System.out.println("\nDonnez le nom du produit numero : " + (i+1) );
            String nomProduit = s.nextLine();
            System.out.println("\nDonnez la quantitee du produit numero : " + (i+1) );
            int qte = s.nextInt();
            s.nextLine();
            int j = chercherDansParapharmaceutique(para, nomProduit);
            boolean expired = (LocalDate.now().isBefore(para.get(j).getDate_exp()));
            if(j != -1){
                if(qte <= para.get(j).getQte() && !expired){
                    facture += para.get(j).vendre(qte, false, false, commandes);
                }else if(qte > para.get(i).getQte() && !expired){ // Quantitee non suffisante ==> achat partiel ou non
                    System.out.println("Produit disponible mais seulement en " + para.get(i).getQte() + "Unitees\nVoulez vous faire un achat partiel ?\nOui ==> 1\nNon ==> 2\n");
                    int choice = s.nextInt();
                    s.nextLine();
                    switch(choice){
                        case 1:
                            facture += para.get(j).vendre(qte, false, false, commandes);
                            break;
                        case 2:
                            System.out.println("Vous avez choisi de ne pas achete ce produit ==> " + para.get(i).getNomProduit() +"\n");
                            break;
                    }
                }else{
                    System.out.println("Ce produit n'est pas disponible\n");
                }
            }else{
                System.out.println("Ce Produit n'est pas disponible\n");
            }

        }
        return facture;
    }

    //Medicament Sans Ordonnance
    public static float facturationSansOrdonnance(ArrayList<MedicamentEnStock> medsEx, ArrayList<String> commandes, float facture){
        Scanner s = new Scanner(System.in);
        System.out.println("Combien de medicaments voulez vous achetez ? repondez par '0' si vous ne souhaitez pas acheter des medicament\n");
        int nb = s.nextInt();
        s.nextLine();
        for(int i =0;i < nb; i++){
            System.out.println("Donnez le nom du Medicaments numero : " + (i+1) +"\n");
            String nomMed = s.nextLine();
            System.out.println("Donnez la quantitee du Medicaments numero : " + (i+1) +"\n");
            int qte = s.nextInt();
            s.nextLine();
            int j = chercherDansExterne(medsEx, nomMed, qte);
            boolean expired = LocalDate.now().isBefore(medsEx.get(j).getDate_exp());
            if(j != -1 && !expired){
                if(medsEx.get(j).isAvecOrdonnance()){
                    System.out.println("Ce medicament est vendu uniquement avec ordonnance !\n");
                }else{
                    if(qte <= medsEx.get(j).getQte()){
                        facture += medsEx.get(j).vendre(qte, false, false, commandes);//On suppose que si un client n'a pas d'ordonnance il ne pourra pas etre rembourssé.
                    }else {
                        System.out.println("Ce medicament est disponible mais seulement en : " + medsEx.get(j).getQte() + " Voulez vous faire un achet partiel ?\n1- Oui\n2- Non\n");
                        int choice = s.nextInt();
                        s.nextLine();
                        switch (choice) {
                            case 1:
                                facture += medsEx.get(j).vendre(medsEx.get(j).getQte(), false, false, commandes);
                                break;
                            case 2:
                                System.out.println("Vous avez choisi de ne pas achete ce produit : " + medsEx.get(i).getNomMed() + "\n");
                                break;
                        }
                    }
                }
            }else{
                System.out.println("Ce Medicament n'est pas disponible\n");
            }
        }
        return facture;
    }
}
