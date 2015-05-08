package patientenverwaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Menue extends JFrame {

    private JButton speichernButton;
    private JTextField vorname;
    private JPanel panel;
    private JTextField nachname;
    private JLabel info;
    private JTextField geburtstag;
    private JTextField wohnort;
    private JTextField adresse;
    public String Vorname;
    public String Nachname;
    public String Geburtstag;
    public String Wohnort;
    public String Adresse;
    private final String StringNachname = "Nachname";
    private final String StringVorname = "Vorname";
    private final String StringGeburtstag = "Geburtstag";
    private final String StringWohnort = "Wohnort";
    private final String StringAdresse = "Adresse";


    public Menue(){

        setBounds(100,100,400,400);
        setVisible(true);
        setContentPane(panel);
        info.setText(" ");
        ButtonInitialisieren();

    }

    public void ButtonInitialisieren(){
        //Speicher Button
        speichernButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vorname = vorname.getText();
                Nachname = nachname.getText();
                Geburtstag = geburtstag.getText();
                Wohnort = wohnort.getText();
                Adresse = adresse.getText();
                if(Vorname.equals(StringVorname)|| Nachname.equals(StringNachname) || Geburtstag.equals(StringGeburtstag)
                        || Wohnort.equals(StringWohnort) || Adresse.equals(StringAdresse))
                {
                    info.setText("Error! Gib alles an");
                }else{

                }
            }
        });
    }
}
