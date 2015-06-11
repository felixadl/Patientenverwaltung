package patientenverwaltung;
import javax.swing.*;
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


    public void PatientSpeichern(String Vorname, String Nachname, String krankheit,boolean notfall){

        Patient p;
        p = new Patient(Vorname, Nachname, krankheit);
        if (!notfall) {
            this.patienten.add(p);
        }else {
            this.patienten.add(1,p);
        }


    }

    public void Autom_fuellen() {

        PrintWriter pWriter=null;
        try{
            pWriter = new PrintWriter(new FileWriter("patienten.txt",true),true);
            new FileOutputStream("patienten.txt").close();
            pWriter.println("Adler"  +" " + "Felix"+ " " + "22.02.1998" + " " + "Am Kirschgarten 1" + " " + "94127 Neuburg/Inn");
            pWriter.println("Adler"  +" " + "Lorenz"+ " " + "22.02.1998" + " " +"Am Kirschgarten 1" + " " + "94127 Neuburg/Inn");
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

    public void ArrayListTextAreaAnzeigen(JTextArea TextArea, JTextArea Behandlung){
        JTextArea Area;
        Area = TextArea;
        JTextArea behandlung;
        behandlung = Behandlung;
        String Patienten = "";
        Patient patient_behandlung = null;

        if(patienten.isEmpty()==false) {
            patient_behandlung = patienten.get(0);
        }

        if (patienten.isEmpty()== true){
            behandlung.setText("Keiner Aktuell in Behandlung");
            Area.setText("");
        }else {
            behandlung.setText(patient_behandlung.PatientInfo());
        }
        if(patienten.size()<=1) {
            Area.setText("");

        }else {
            for (int i = 1; i < patienten.size(); i++) {

                String p = "";
                Patient patient;
                patient = patienten.get(i);
                p = patient.PatientInfo();
                Patienten = Patienten + " " + p + "\n";
                System.out.println(Patienten);
                Area.setText(Patienten);
            }
        }
    }

    public void dernaechste(JTextArea TextArea, JTextArea Behandlung){
        if(patienten.size()!=0){
            patienten.remove(0);
            ArrayListTextAreaAnzeigen(TextArea,Behandlung);
        }else{

        }

    }
}