package patientenverwaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Menue extends JFrame {

    private JButton speichernButton;
    private JTextField vorname;
    private JPanel panel;
    private JTextField nachname;
    public String Vorname;
    public String Nachname;


    public Menue(){

        setBounds(100,100,400,400);
        setVisible(true);
        setContentPane(panel);

        ButtonInitialisieren();

    }

    public void ButtonInitialisieren(){
        //Speicher Button
        speichernButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vorname = vorname.getText();
                Nachname = nachname.getText();
                System.out.println(Vorname + " " + Nachname);
            }
        });
    }
}
