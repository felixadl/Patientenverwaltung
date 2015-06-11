package patientenverwaltung;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {
//Klasse Main

    public static Startmenü st;
    public static Controller c;

    public static void main(String[] args) {

         c = new Controller();
        //Menue m = new Menue(c);
        st = new Startmenü();



    }




}

