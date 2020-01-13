/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

/**
 *
 * @author pc
 */
public class Diabetecheck {
    String Firstcase;
    String Secondcase;
    public Diabetecheck(String Firstcase,String Secondcase ){
    
    try {
            this.Firstcase=Firstcase;
            this.Secondcase=Secondcase;
            Instances dataset=new Instances(new BufferedReader(new FileReader("C:\\Users\\pc\\Documents\\NetBeansProjects\\Projet_IA\\src\\projet_ia\\diabetes.arff")));
            Instances test=new Instances(new BufferedReader(new FileReader("C:\\Users\\pc\\Documents\\NetBeansProjects\\Projet_IA\\src\\projet_ia\\diabetes2.arff")));
            
            test.setClassIndex(dataset.numAttributes()-1);
            dataset.setClassIndex(dataset.numAttributes()-1);
            
            
            J48 j48=new J48();
            j48.buildClassifier(dataset);

            Evaluation eval = new Evaluation(dataset);  
            
            
            
            eval.evaluateModel(j48,test);
                
            if(eval.correct()==1)
                    {
                       System.out.println("tested_positive");
                    JOptionPane.showMessageDialog(new Fenetre(),"tested_positive","A plain message",JOptionPane.PLAIN_MESSAGE);
                    BufferedWriter output = new BufferedWriter(new FileWriter("C:\\Users\\pc\\Documents\\NetBeansProjects\\Projet_IA\\src\\projet_ia\\diabetes.arff", true));
                    output.append(Firstcase);
                    output.append('\n');
                    output.close();}
            else
                    {System.out.println("tested_negative");
                    JOptionPane.showMessageDialog(new Fenetre(),"tested_negative","A plain message",JOptionPane.PLAIN_MESSAGE);
                    BufferedWriter output = new BufferedWriter(new FileWriter("C:\\Users\\pc\\Documents\\NetBeansProjects\\Projet_IA\\src\\projet_ia\\diabetes.arff", true));
                    output.append(Secondcase);
                    output.append('\n');
                    output.close();}
            
              try{
             RandomAccessFile raf = new RandomAccessFile("C:\\Users\\pc\\Documents\\NetBeansProjects\\Projet_IA\\src\\projet_ia\\diabetes2.arff", "rw");
             long length = raf.length();
             
              
             raf.setLength(length - Firstcase.length());
             
             raf.close();
             
             }catch(Exception ex){
             ex.printStackTrace();
         }
        
        
        }

    
catch (FileNotFoundException ex) {
            Logger.getLogger(Diabetecheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Diabetecheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diabetecheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
