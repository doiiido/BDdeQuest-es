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
public class Dificuldade extends BDgen {
        public static int adicionar (String dificuldade,String nome){
            if(dificuldade.equals("Fácil")){
                banco = "Indices/Fácil.txt";
            }else{
                if(dificuldade.equals("Média")){
                    banco = "Indices/Média.txt";
                }else{
                banco = "Indices/Difícil.txt";
                }
            }
        return adicionar(nome);
    }
    public static int removerdificuldade (String nome){
            try {
                File file = new File("Questoes/"+nome);
                File buff = new File("Indices/buff.txt");
                if(!buff.exists()) {
                    buff.createNewFile();
                }
                Scanner fileIn = new Scanner(file);
                String lingua = fileIn.nextLine();
                String assunto = fileIn.nextLine();
                String tipo = fileIn.nextLine();
                String dificuldade = fileIn.nextLine();
                banco = "Indices/"+dificuldade+".txt";
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
                    adicionar(dificuldade,fileIn.nextLine());
                }
                fileIn.close();
                buff.delete();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Lingua.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 20)");
            } catch (IOException ex) {
                Logger.getLogger(Lingua.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 21)");
            }
        return 0;
    }
    public static int editar (String Lingua,String nome){
        return 0;
    }
    public static String [] buscarand (String Lingua, int num){
        String [] nomes = null;
        return nomes;
    }
}
