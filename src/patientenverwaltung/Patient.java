package patientenverwaltung;
import java.util.ArrayList;


public class Patient {

    private String geburtstag;
    private String vorname;
    private String nachname;
    private String wohnort;
    private String adresse;
    //private ArrayList<String> krankheiten;


    public Patient (String vorname, String nachname, String geburtstag, String adresse, String wohnort) {

        this.geburtstag = geburtstag;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.wohnort = wohnort;
        //this.krankheiten = new ArrayList<String>();

    }




    public void setKrankheiten(String krankheit) {

           // this.krankheiten.add(krankheit);


    }




}
