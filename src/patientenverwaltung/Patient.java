package patientenverwaltung;
import java.util.ArrayList;



public class Patient {

    private int alter;
    private String vorname;
    private String nachname;
    private String wohnort;
    private ArrayList<String> krankheiten;


    public Patient (String vorname, String nachname, int alter, String wohnort) {

        this.alter = alter;
        this.vorname = vorname;
        this.nachname = nachname;
        this.wohnort = wohnort;
        this.krankheiten = new ArrayList<String>();

    }




    public void setKrankheiten(String krankheit) {

            this.krankheiten.add(krankheit);


    }




}
