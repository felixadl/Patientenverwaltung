package patientenverwaltung;

import com.sun.org.apache.xerces.internal.xs.StringList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

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
    private JComboBox patientenList;
    private JButton Sortieren;
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
    PrintWriter pWriter = null;


    public Menue(Controller c){

        setBounds(100, 100, 550, 550);
        setVisible(true);
        setContentPane(panel);
        ButtonInitialisieren();
        this.controller = c;
        ComboBoxFill();

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

        Sortieren.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortTxt("patienten");
            }
        });
    }

    public void ComboBoxFill(){

        SortTxt("patienten");

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

    public void SortTxt(String txt){
        String line;
        int StringLenght = 0;
        ArrayList TXT = new ArrayList();
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
            FileReader reader = new FileReader(txt+ ".txt");
            BufferedReader bfreader = new BufferedReader(reader);

            for (int i = 0;(line = bfreader.readLine()) != null; i++) {
                TXT.add(line);
            }
        }catch(IOException ioe){
            System.out.println();
        }
        TXT.sort(null);

        try{
            pWriter = new PrintWriter(new FileWriter("patienten.txt"));
            for(int i = 0 ; i < TXT.size(); i++) {
                pWriter.println(TXT.get(i).toString());
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            if(pWriter != null) {
                pWriter.flush();
                pWriter.close();
            }

        }

    }

}
