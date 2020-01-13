/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author pc
 */
public class Fenetre extends JFrame{
    
    JTextField j1;
    JLabel lab1;
    JTextField j2;
    JLabel lab2;
    JTextField j3;
    JLabel lab3;
    JTextField j4;
    JLabel lab4;
    JTextField j5;
    JLabel lab5;
    JTextField j6;
    JLabel lab6;
    JTextField j7;
    JLabel lab7;
    JTextField j8;
    JLabel lab8;
    JPanel panel;
    JLabel lab9;
 

    JButton btn;
    public Fenetre(){
    this.setSize(500, 500);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    init();
    }
    public void init(){
    j1=new JTextField("");
    j2=new JTextField("");
    j3=new JTextField("");
    j4=new JTextField("");
    j5=new JTextField("");
    j6=new JTextField("");
    j7=new JTextField("");
    j8=new JTextField("");
    lab1=new JLabel("Number of times pregnant");
    lab2=new JLabel("Plasma glucose concentration a 2 hours in an oral glucose tolerance test");
    lab3=new JLabel("Diastolic blood pressure (mm Hg)");
    lab4=new JLabel("Triceps skin fold thickness (mm)");
    lab5=new JLabel("2-Hour serum insulin (mu U/ml)");
    lab6=new JLabel("Body mass index (weight in kg/(height in m)^2)");
    lab7=new JLabel("Diabetes pedigree function");
    lab8=new JLabel("Age (years)");
    btn=new JButton("Tester");
    lab9=new JLabel("Diabetes Detector");
    lab9.setFont(new Font("",Font.BOLD, 38));
    lab9.setForeground(Color.GRAY);
    lab9.setHorizontalAlignment(JLabel.CENTER);
    panel=new JPanel();
    panel.setLayout(new GridLayout(17,1));
    panel.setBorder(BorderFactory.createTitledBorder("Informations :"));
    panel.add(lab1);
    panel.add(j1);
    panel.add(lab2);
    panel.add(j2);
    panel.add(lab3);
    panel.add(j3);
    panel.add(lab4);
    panel.add(j4);
    panel.add(lab5);
    panel.add(j5);
    panel.add(lab6);
    panel.add(j6);
    panel.add(lab7);
    panel.add(j7);
    panel.add(lab8);
    panel.add(j8);
    //panel.add(btn);
    setLayout(new BorderLayout());
    add("Center",panel);
    add("North",lab9);
    add("South",btn);
    btn.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ex){
	
            String positive="";
            String negative="";
            String a=(j1.getText());
            String b=(j2.getText());
            String c=(j3.getText());
            String d=(j4.getText());
            String e=(j5.getText());
            String f=(j6.getText());
            String g=(j7.getText());
            String h=(j8.getText());
            
            
            try {
                
                BufferedWriter output = new BufferedWriter(new FileWriter("C:\\Users\\pc\\Documents\\NetBeansProjects\\Projet_IA\\src\\projet_ia\\diabetes2.arff", true));

                positive=a+','+b+','+c+','+d+','+e+','+f+','+g+','+h+','+"tested_positive";

                negative=a+','+b+','+c+','+d+','+e+','+f+','+g+','+h+','+"tested_negative";
                output.append(positive);
                output.close();
                new Diabetecheck(positive,negative);
            } catch (IOException ex1) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex1);
            }


	}
    });
    }
    public static void main (String [] args){
    Fenetre f=new Fenetre();
    f.show();
    }
    
}
