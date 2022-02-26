package com.pharm;

import java.util.ArrayList;

public class ClientPermanent {
    private String nomClient;
    private String prenomClient;
    private String ageClient;
    private int NSS;
    private boolean affiliation;
    private ArrayList<String> maladie;
    private ArrayList<MedicamentPrescrit> traitement;

    public ClientPermanent(String nomClient, String prenomClient, String ageClient, int NSS, boolean affiliation, ArrayList<String> maladie) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.ageClient = ageClient;
        this.maladie = maladie;
        traitement = new ArrayList<MedicamentPrescrit>();
        this.affiliation = affiliation;
        if(affiliation){
            this.NSS = NSS;
        }else{
            this.NSS = 0;
        }

    }
    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public String getAgeClient() {
        return ageClient;
    }

    public boolean isAffiliation() {
        return affiliation;
    }

}
