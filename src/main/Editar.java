/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Linco
 */
public class Editar {
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    public static int edit(String Assunto,String Materia,String Tipo,String Dificuldade,String Questao,String nome) throws IOException{
        try {
                Banco.BDgen.remover(nome);
                File arqQuestao = new File("Questoes/"+nome);
                if(!arqQuestao.exists()){
                    arqQuestao.createNewFile();
                }else{
                     arqQuestao.delete();
                     arqQuestao.createNewFile();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 4)");
                return -1;
            }
            String linhas[] = Questao.split(System.lineSeparator());
            try (PrintWriter arqQuestao = new PrintWriter(new FileWriter("Questoes/"+nome, true))) {
                arqQuestao.println(Materia);
                arqQuestao.println(Assunto);
                arqQuestao.println(Tipo);
                arqQuestao.println(Dificuldade);
                arqQuestao.println("          ");
                for (String linha : linhas) {
                    arqQuestao.println(linha);
                }
                arqQuestao.close();
            }
            
            
            try {
                File file = new File("Indices/IndiceDeNomes.txt");
                if(file.exists()) {
                    try (Scanner fileIn = new Scanner(file)) {
                    String buff;
                    Boolean found=false;
                        while(fileIn.hasNextLine()){
                            buff= fileIn.nextLine();
                            if(buff.equals(nome))
                                found=true;
                        }
                        fileIn.close();
                        if(!found){
                            int i=1;
                        try (Scanner input = new Scanner(file)) {
                            while(input.hasNextLine()){
                                i++;
                                input.nextLine();
                            }
                        }
                            try (PrintWriter writer = new PrintWriter(new FileWriter("Indices/IndiceDeNomes.txt", true))) {
                                writer.println(i+".txt");
                                writer.close();
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 1)");
                                return -1;
                            }
                        }
                    }
                }else{
                    file.createNewFile();
                    try (PrintWriter writer = new PrintWriter(file)) {
                        writer.println("1.txt");
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 33)");
                return -1;
            }
            Banco.Materia.adicionar(Materia, nome);
            Banco.Assunto.adicionar(Assunto, nome);
            Banco.Tipo.adicionar(Tipo, nome);
            Banco.Dificuldade.adicionar(Dificuldade, nome);
        JOptionPane.showMessageDialog(null, "Questao "+nome+" editada com sucesso");
        return 0;
    }
}

