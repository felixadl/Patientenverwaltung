package patientenverwaltung;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


public class Rezept extends JFrame {

    private JPanel panel;
    private JComboBox patientenList;
    private JButton patientUebernehmenButton;
    private JTextField vornametxt;
    private JTextField nachnametxt;
    private JTextField geburtsdatumtxt;
    private JButton rezeptErstellenButton;


    public Rezept () {

        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);
        this.setContentPane(this.panel);
        super.setTitle("Rezept erstellen");
        this.ComboBoxFill();
        this.ButtonInitialisieren();


    }

    private void ButtonInitialisieren() {


        patientUebernehmenButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String PatientLang = (String) patientenList.getSelectedItem();
                String[] patientString = PatientLang.split(" ");

                vornametxt.setText(patientString[0]);
                nachnametxt.setText(patientString[1]);
                geburtsdatumtxt.setText(patientString[2]);
            }
        });


        rezeptErstellenButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {



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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}



