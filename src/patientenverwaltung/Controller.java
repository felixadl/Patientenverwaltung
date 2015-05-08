package patientenverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public List<Patient> patienten = new ArrayList<Patient>();

    public void PatientSpeichern(String Geburtstag, String Wohnort, String Adresse, String Nachname, String Vorname){
        Patient p = new Patient(Vorname, Nachname,Geburtstag, Wohnort,Adresse);

    }

}
