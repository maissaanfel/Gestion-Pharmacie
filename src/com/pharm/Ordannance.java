package com.pharm;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ordannance {
    private String nomClient;
    private String prenomClient;
    private String ageClient;
    private String nomMedecin;
    private String prenomMedecin;
    private String specialiteMedecin;
    private String adresseMedecin;
    private LocalDate date;
    private ArrayList<MedicamentPrescrit> medP;

    public Ordannance(String nomClient, String prenomClient, String ageClient, String nomMedecin, String prenomMedecin, String specialiteMedecin, String adresseMedecin, LocalDate date, ArrayList<MedicamentPrescrit> medP) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.ageClient = ageClient;
        this.nomMedecin = nomMedecin;
        this.prenomMedecin = prenomMedecin;
        this.specialiteMedecin = specialiteMedecin;
        this.adresseMedecin = adresseMedecin;
        this.date = date;
        this.medP = medP;
    }

    public ArrayList<MedicamentPrescrit> getMedP() {
        return medP;
    }

    public String getAgeClient() {
        return ageClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }
}
