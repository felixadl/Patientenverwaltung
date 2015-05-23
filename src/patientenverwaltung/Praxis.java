package patientenverwaltung;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by schueler on 21.05.2015.
 */
public class Praxis extends JFrame{
    private JPanel panel;
    private JComboBox patientenList;

    public Praxis(){
        setBounds(100, 100, 550, 550);
        setVisible(true);
        setContentPane(panel);
        super.setTitle("Praxis");
        ComboBoxFill();
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
