package patientenverwaltung;
import java.util.ArrayList;


public class Patient {

    private String vorname;
    private String nachname;
    private String krankheit;
    //private ArrayList<String> krankheiten;


    public Patient (String vorname, String nachname, String krankheit) {

        this.vorname = vorname;
        this.nachname = nachname;
        this.krankheit = krankheit;
        //this.krankheiten = new ArrayList<String>();

    }

    public String PatientInfo(){
        String p = vorname + " " + nachname + " " + krankheit;
        return p;
    }


    public void setKrankheiten(String krankheit) {

           // this.krankheiten.add(krankheit);


    }




}
