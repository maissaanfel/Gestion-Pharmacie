package com.pharm;

import java.util.ArrayList;

public interface Calcul {
    void miseAjourduStock(int qte);
    boolean seuilAtteint();
    void envoyerCommande(ArrayList<String> commandes);
    float vendre(int qte, boolean affiliationClient, boolean clientAvecOrdonnance, ArrayList<String> commandes);

}
