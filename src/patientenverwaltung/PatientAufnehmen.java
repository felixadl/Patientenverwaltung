package patientenverwaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PatientAufnehmen extends JFrame{
    private JPanel panel;
    private JComboBox patientenList;
    private JTextField Krankheit;
    private JCheckBox checkBox1;
    private JButton warteliste;



    public PatientAufnehmen(){
        setBounds(100, 100, 550, 550);
        setVisible(true);
        setContentPane(panel);
        super.setTitle("Patienten Aufnehmen");
        ComboBoxFill();
        ButtonInitialisieren();
    }

    private void ButtonInitialisieren() {
        warteliste.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String krankheit = Krankheit.getText();
                String Notfall;
                boolean notfall = false;
                if (checkBox1.isSelected()) {
                    notfall = true;
                    Notfall = "ACHTUNG! NOTFALL";
                } else {
                    notfall = false;
                    Notfall = "kein Notfall";
                }
                String PatientLang = (String) patientenList.getSelectedItem();
                String[] patientString = PatientLang.split(" ");
                String Patient = patientString[0] + " " + patientString[1] + " " + krankheit + Notfall;
                Main.c.PatientSpeichern(patientString[0], patientString[1], krankheit + Notfall, notfall);
                Main.st.GuiAktualisieren();
            }
        });


    }

    public void ComboBoxFill(){
        String line;
        int StringLenght = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("patienten.txt"));
            int count = 0;
            while( reader.readLine() != null){
                count ++;
            }
            StringLenght = count;
        }catch (Exception ex){
            ex.printStackTrace();
        }

        String array[] = new String[StringLenght];
        try{
            FileReader reader = new FileReader("patienten.txt");
            BufferedReader bfreader = new BufferedReader(reader);

            for (int i = 0;(line = bfreader.readLine()) != null; i++) {
                patientenList.addItem(line);
            }
        }catch(IOException ioe){
            System.out.println();
        }

    }
}
