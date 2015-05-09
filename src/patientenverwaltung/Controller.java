package patientenverwaltung;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    public ArrayList<Patient> patienten;


    public Controller() {

        this.patienten = new ArrayList<Patient>();

    }


    public void PatientSpeichern(String Vorname, String Nachname, String Geburtstag, String Adresse, String Wohnort) {

        Patient p = new Patient(Vorname, Nachname, Geburtstag, Adresse, Wohnort);

        this.patienten.add(p);

        System.out.println("Neuer Patient: " + Vorname + " " + Nachname + ", geboren am " + Geburtstag + ", wohnhaft in " + Adresse + ", " + Wohnort + ".");

    }


}