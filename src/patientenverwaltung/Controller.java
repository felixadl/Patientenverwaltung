package patientenverwaltung;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    public ArrayList<Patient> patienten;


    public Controller() {

        this.patienten = new ArrayList<Patient>();
        Autom_fuellen();

    }


    public void PatientSpeichern(String Vorname, String Nachname, String Geburtstag, String Adresse, String Wohnort) {

        Patient p = new Patient(Vorname, Nachname, Geburtstag, Adresse, Wohnort);

        this.patienten.add(p);
        

        System.out.println("Neuer Patient: " + Vorname + " " + Nachname + ", geboren am " + Geburtstag + ", wohnhaft in " + Adresse + ", " + Wohnort + ".");

    }

    public void Autom_fuellen() {

        PrintWriter pWriter=null;
        try{
            pWriter = new PrintWriter(new FileWriter("patienten.txt",true),true);
            new FileOutputStream("patienten.txt").close();
            pWriter.println("Adler"  +" " + "Felix"+ " " + "22.02.98.1998" + " " + "Am Kirschgarten 1" + " " + "94127 Neuburg/Inn");
            pWriter.println("Adler"  +" " + "Lorenz"+ " " + "22.02.98.1998" + " " +"Am Kirschgarten 1" + " " + "94127 Neuburg/Inn");
            pWriter.println("Wik"  +" " + "Julian"+ " " + "29.08.1997" + " " + "Brunnfeld 14" + " " + "94127 Neuburg/Inn");
            pWriter.println("Ellinger"  +" " + "Jonas"+ " " + "22.01.1998" + " " + "Heiningerstrasse 44a" + " " + "94036 Passau");
        } catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            if(pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }
    }



}