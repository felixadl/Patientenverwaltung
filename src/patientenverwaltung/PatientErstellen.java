package patientenverwaltung;

import com.sun.org.apache.xerces.internal.xs.StringList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

import static patientenverwaltung.Controller.*;


public class PatientErstellen extends JFrame {

    private JButton speichernButton;
    private JTextField vorname;
    private JPanel panel;
    private JTextField nachname;
    private JLabel info;
    private JTextField geburtstag;
    private JTextField adresse;
    private JTextField wohnort;
    public String Vorname;
    public String Nachname;
    public String Geburtstag;
    public String Adresse;
    public String Wohnort;
    private final String StringNachname = "Nachname";
    private final String StringVorname = "Vorname";
    private final String StringGeburtstag = "Geburtstag";
    private final String StringAdresse = "Adresse";
    private final String StringWohnort = "Wohnort";
    //public Controller controller;
    PrintWriter pWriter = null;


    public PatientErstellen(){

        setBounds(100, 100, 550, 300);
        setVisible(true);
        setContentPane(panel);
        super.setTitle("Patienten Erstellen");
        ButtonInitialisieren();
        super.setTitle("Neuen Patienten hinzufügen");

    }

    public void ButtonInitialisieren(){
        //Speicher Button
        speichernButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vorname = vorname.getText();
                Nachname = nachname.getText();
                Geburtstag = geburtstag.getText();
                Adresse = adresse.getText();
                Wohnort = wohnort.getText();

                if(Vorname.equals(StringVorname)|| Nachname.equals(StringNachname) || Geburtstag.equals(StringGeburtstag)
                        || Adresse.equals(StringAdresse) || Wohnort.equals(StringWohnort))
                {
                    info.setText("Error! Bitte alle Informationen angeben");
                }

                else if(Vorname.equals("") || Nachname.equals("") || Geburtstag.equals("") || Adresse.equals("") || Wohnort.equals("") )
                {
                    info.setText("Error! Bitte alle Informationen angeben");
                }

                else {
                    //Patient der eingegeben wurde in txt datei speichern
                    try{
                        pWriter = new PrintWriter(new FileWriter("patienten.txt",true),true);
                        pWriter.println(Nachname  +" " + Vorname+ " " + Geburtstag + " " + Adresse + " " + Wohnort);
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
            }
         );
    }

}
