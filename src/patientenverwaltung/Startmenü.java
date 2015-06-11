package patientenverwaltung;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;


public class Startmenü extends JFrame{

   private JButton neuenPatientenZurPraxisButton;
    private JPanel panel;
    private JButton patientInPraxisAufnehmenButton;
    PrintWriter pWriter = null;

    public Startmenü(){
        setBounds(100, 100, 550, 550);
        setVisible(true);
        setContentPane(panel);
        ButtonInitalisieren();
        super.setTitle("Startmenü");
        SortTxt("patienten");
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
                Controller c = new Controller();
                Praxis p = new Praxis(c);
            }
        });
    }

    public void SortTxt(String txt){
        String line;
        int StringLenght = 0;
        ArrayList TXT = new ArrayList();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(txt+ ".txt"));
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
            pWriter = new PrintWriter(new FileWriter(txt +".txt"));
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
