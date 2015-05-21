package patientenverwaltung;


import javax.swing.*;
import java.awt.event.ActionEvent;


public class Startmenü extends JFrame{

   private JButton neuenPatientenZurPraxisButton;
    private JPanel panel;
    private JButton patientInPraxisAufnehmenButton;
    public Controller controller;

    public Startmenü(Controller c){
        setBounds(100, 100, 550, 550);
        setVisible(true);
        setContentPane(panel);
        this.controller = c;
        ButtonInitalisieren();
}

    public void ButtonInitalisieren(){
        neuenPatientenZurPraxisButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menue m = new Menue();
            }
        });

        patientInPraxisAufnehmenButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Praxis p = new Praxis();
            }
        });
    }
}
