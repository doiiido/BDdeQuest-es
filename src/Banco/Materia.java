/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import static Banco.BDgen.banco;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Linco
 */
public class Materia extends BDgen {
        public static int adicionar (String materia,String nome){
           try {
                File file = new File("Indices/Matérias.txt");
                if(!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException ex) {
                        Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 25)");
                    }
                }
                banco = null;
                Scanner fileIn = new Scanner(file);
                while(fileIn.hasNextLine()){
                    String materias = fileIn.nextLine();
                    if(materia.equals(materias)){
                        banco = "Indices/Matéria/"+materia+".txt";
                    }
                }
                fileIn.close();
                if(banco == null){
                    banco = "Indices/Matérias.txt";
                    adicionar(materia);
                    banco = "Indices/Matéria/"+materia+".txt";
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa(Erro 38)!");
            }
            return adicionar(nome);
    }
        
    public static int removermateria (String nome){    
        try {
                File buff = new File("Indices/buff.txt");
                if(!buff.exists()) {
                    buff.createNewFile();
                }
                banco = "Indices/Matérias.txt";
                File file = new File(banco);
                if(!file.exists())
                    file.createNewFile();
                Scanner fileIn = new Scanner(file);
                String questao="";
                PrintWriter writer = new PrintWriter(new FileWriter("Indices/buff.txt", true));
                while(fileIn.hasNextLine()){
                    if(fileIn.hasNextLine())
                        questao = fileIn.nextLine();
                    if(!questao.equals(nome))
                        writer.println(questao);
                }
                writer.close();
                fileIn.close();
                file.delete();
                fileIn = new Scanner(buff);
                while(fileIn.hasNextLine()){
                    adicionar(fileIn.nextLine());
                }
                fileIn.close();
                buff.delete();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 36)");
            } catch (IOException ex) {
                Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 37)");
            }
        return 0;
    }
        
    public static int removerquestao (String nome){
            try {
                File file = new File("Questoes/"+nome);
                File buff = new File("Indices/buff.txt");
                if(!buff.exists()) {
                    buff.createNewFile();
                }
                Scanner fileIn = new Scanner(file);
                String materia = fileIn.nextLine();
                String assunto = fileIn.nextLine();
                String tipo = fileIn.nextLine();
                String dificuldade = fileIn.nextLine();
                banco = "Indices/Matéria/"+materia+".txt";
                fileIn.close();
                file = new File(banco);
                if(!file.exists())
                    file.createNewFile();                    
                fileIn = new Scanner(file);
                String questao="";
                PrintWriter writer = new PrintWriter(new FileWriter("Indices/buff.txt", true));
                while(fileIn.hasNextLine()){
                    if(fileIn.hasNextLine())
                        questao = fileIn.nextLine();
                    if(!questao.equals(nome))
                        writer.println(questao);
                }
                writer.close();
                fileIn.close();
                file.delete();
                fileIn = new Scanner(buff);
                while(fileIn.hasNextLine()){
                    adicionar(materia,fileIn.nextLine());
                }
                fileIn.close();
                buff.delete();
                file = new File("Indices/Matéria/"+materia+".txt");
                if(!file.exists()) {
                   removermateria(materia);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro18)");
            } catch (IOException ex) {
                Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 19)");
            }
        return 0;
    }
}