package patientenverwaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static patientenverwaltung.Controller.*;


public class Menue extends JFrame {

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
    public Controller controller;


    public Menue(Controller c){

        setBounds(100, 100, 550, 550);
        setVisible(true);
        setContentPane(panel);
        ButtonInitialisieren();
        this.controller = c;

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

                    controller.PatientSpeichern(Vorname, Nachname, Geburtstag, Adresse, Wohnort);


                }
                }
            }
         );
    }
}
