package interf;

import javax.swing.*;
import java.awt.event.ActionListener;
public class Interface extends JFrame {
    private JPanel Panel;
    private JTextField nrClienti;
    private JTextField nrCozi;
    private JTextField arrivMax;
    private JTextField arrivMin;
    private JTextField serviceMax;
    private JTextField serviceMin;
    private JTextField simu;
    private JButton run;

    public Interface(){
        setSize(800,400);
        setContentPane(Panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Integer getNrClienti() {
       try{//citirea valorilor pentru simulare
           return Integer.parseInt(nrClienti.getText());
       }
       catch(NumberFormatException e){
           JOptionPane.showMessageDialog(Panel, "Dati un text valid!");
           return 0;
        }
    }

    public Integer getNrCozi() {
        try{
            return Integer.parseInt(nrCozi.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(Panel, "Dati un text valid!");
            return 0;
        }
    }

    public Integer getArrivMax() {
        try{
            return Integer.parseInt(arrivMax.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(Panel, "Dati un text valid!");
            return 0;
        }
    }

    public Integer getArrivMin() {
        try{
            return Integer.parseInt(arrivMin.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(Panel, "Dati un text valid!");
            return 0;
        }
    }

    public Integer getServiceMax() {
        try{//citirea valorilor pentru simulare
            return Integer.parseInt(serviceMax.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(Panel, "Dati un text valid!");
            return 0;
        }
    }

    public Integer getServiceMin() {
        try{//citirea valorilor pentru simulare
            return Integer.parseInt(serviceMin.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(Panel, "Dati un text valid!");
            return 0;
        }
    }
    public Integer getSimu(){
        try{//citirea valorilor pentru simulare
            return Integer.parseInt(simu.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(Panel, "Dati un text valid!");
            return 0;
        }
    }
    public void addButtonListener(ActionListener l){
        //buton simulare

    }
}
