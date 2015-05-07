package patientenverwaltung;

import java.util.ArrayList;

/**
 * Created by Jonas on 07.05.2015.
 */

public class Patient {

    private int alter;
    private String vorname;
    private String nachname;
    private String wohnort;
    private ArrayList krankheiten;


    public Patient (String vorname, String nachname, int alter, String wohnort) {

        this.alter = alter;
        this.vorname = vorname;
        this.nachname = nachname;
        this.wohnort = wohnort;

        this.krankheiten = new ArrayList;
    }


    public void setKrankheiten(String krankheit) {




    }




}
