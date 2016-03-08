/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Linco
 */
public class Busca {
    
    private static List<String> Compara(List<String> list1, List<String> list2) {
        List<String> resultado = new ArrayList<>();
        int i=0;
        if(list1.isEmpty()||list2.isEmpty())
            return resultado;
        while(i<list1.size()){
            if(list2.contains(list1.get(i)))
                resultado.add(list1.get(i));
            i++;
        }
        return resultado;
    }
    
    public static String buscar(String Assunto,String Materia,String Tipo,String Dificuldade,int numero){
    List<String> listAssunto = new ArrayList<>();
    List<String> listMateria = new ArrayList<>();
    List<String> listTipo = new ArrayList<>();
    List<String> listDificuldade = new ArrayList<>();
    List<String> Questoes = new ArrayList<>();
    String listquestoes = new String();
    int i=0,j=0;
    try{
    File arqAssunto=null, arqMateria=null, arqTipo=null, arqDificuldade=null;
            if(!Assunto.isEmpty()){
                arqAssunto = new File("Indices/Assunto/"+Assunto+".txt");
                if(!arqAssunto.exists()){
                    JOptionPane.showMessageDialog(null, "Erro no Banco de Dados, por favor revalide o banco (no menu ferramentas, na tela inicial do programa)");
                    GUI.Busca.pag2.dispose();
                    GUI.Pg1.pag1.setVisible(true);
                    return null;
                }
                j+=1;
            }
            if(!Materia.isEmpty()){
                arqMateria = new File("Indices/Matéria/"+Materia+".txt");
                if(!arqMateria.exists()){
                    JOptionPane.showMessageDialog(null, "Erro no Banco de Dados, por favor revalide o banco (no menu ferramentas, na tela inicial do programa)");
                    GUI.Busca.pag2.dispose();
                    GUI.Pg1.pag1.setVisible(true);
                    return null;
                }
                j+=2;
            }
            if(!Tipo.isEmpty()){
                arqTipo = new File("Indices/"+Tipo+".txt");
                if(!arqTipo.exists()){
                    JOptionPane.showMessageDialog(null, "Erro no Banco de Dados, por favor revalide o banco (no menu ferramentas, na tela inicial do programa)");
                    GUI.Busca.pag2.dispose();
                    GUI.Pg1.pag1.setVisible(true);
                    return null;
                }
                j+=4;
            }
            if(!Dificuldade.isEmpty()){
                arqDificuldade = new File("Indices/"+Dificuldade+".txt");
                if(!arqDificuldade.exists()){
                    JOptionPane.showMessageDialog(null, "Erro no Banco de Dados, por favor revalide o banco (no menu ferramentas, na tela inicial do programa)");
                    GUI.Busca.pag2.dispose();
                    GUI.Pg1.pag1.setVisible(true);
                    return null;
                }
                j+=8;
            }
            Scanner fileIn;
            switch (j){
                case 1://assunto
                    fileIn = new Scanner(arqAssunto);
                    while (fileIn.hasNextLine()){
                        listAssunto.add(fileIn.nextLine());
                    }
                    Questoes = listAssunto;
                    fileIn.close();
                    break;
                case 2://materia
                    fileIn = new Scanner(arqMateria);
                    while (fileIn.hasNextLine()){
                        listMateria.add(fileIn.nextLine());
                    }
                    Questoes = listMateria;
                    fileIn.close();
                    break;
                case 3://assunto e materia
                    fileIn = new Scanner(arqAssunto);
                    while (fileIn.hasNextLine()){
                        listAssunto.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqMateria);
                    while (fileIn.hasNextLine()){
                        listMateria.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    Questoes = Compara (listMateria, listAssunto);
                    break;
                case 4://tipo
                    fileIn = new Scanner(arqTipo);
                    while (fileIn.hasNextLine()){
                        listTipo.add(fileIn.nextLine());
                    }
                    Questoes = listTipo;
                    fileIn.close();
                    break;
                case 5://tipo e assunto
                    fileIn = new Scanner(arqTipo);
                    while (fileIn.hasNextLine()){
                        listTipo.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqAssunto);
                    while (fileIn.hasNextLine()){
                        listAssunto.add(fileIn.nextLine());
                    }
                    Questoes = Compara(listAssunto, listTipo);
                    fileIn.close();
                    break;
                case 6://tipo e materia
                    fileIn = new Scanner(arqTipo);
                    while (fileIn.hasNextLine()){
                        listTipo.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqMateria);
                    while (fileIn.hasNextLine()){
                        listMateria.add(fileIn.nextLine());
                    }
                    Questoes = Compara (listMateria, listTipo);
                    fileIn.close();
                    break;
                case 7://tipo, assunto e materia
                    fileIn = new Scanner(arqTipo);
                    while (fileIn.hasNextLine()){
                        listTipo.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqAssunto);
                    while (fileIn.hasNextLine()){
                        listAssunto.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqMateria);
                    while (fileIn.hasNextLine()){
                        listMateria.add(fileIn.nextLine());
                    }
                    Questoes = Compara (listMateria, listTipo);
                    Questoes = Compara (listAssunto, Questoes);
                    fileIn.close();
                    break;
                case 8://dificuldade
                    fileIn = new Scanner(arqDificuldade);
                    while (fileIn.hasNextLine()){
                        listDificuldade.add(fileIn.nextLine());
                    }
                    Questoes = listDificuldade;
                    fileIn.close();
                    break;
                case 9://dificuldade e assunto
                    fileIn = new Scanner(arqDificuldade);
                    while (fileIn.hasNextLine()){
                        listDificuldade.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqAssunto);
                    while (fileIn.hasNextLine()){
                        listAssunto.add(fileIn.nextLine());
                    }
                    Questoes = Compara(listAssunto, listDificuldade);
                    fileIn.close();
                    break;
                case 10://dificuldade materia
                    fileIn = new Scanner(arqDificuldade);
                    while (fileIn.hasNextLine()){
                        listDificuldade.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqMateria);
                    while (fileIn.hasNextLine()){
                        listMateria.add(fileIn.nextLine());
                    }
                    Questoes = Compara (listMateria, listDificuldade);
                    fileIn.close();
                    break;
                case 11://dificuldade, assunto e materia
                    fileIn = new Scanner(arqDificuldade);
                    while (fileIn.hasNextLine()){
                        listDificuldade.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    while (fileIn.hasNextLine()){
                        listAssunto.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqMateria);
                    while (fileIn.hasNextLine()){
                        listMateria.add(fileIn.nextLine());
                    }
                    Questoes = Compara (listMateria, listTipo);
                    Questoes = Compara (listAssunto, Questoes);
                    Questoes = Compara (listDificuldade, Questoes);
                    fileIn.close();
                    break;
                case 12://dificuldade e tipo
                    fileIn = new Scanner(arqDificuldade);
                    while (fileIn.hasNextLine()){
                        listDificuldade.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqTipo);
                    while (fileIn.hasNextLine()){
                        listTipo.add(fileIn.nextLine());
                    }
                    Questoes = Compara (listDificuldade, listTipo);
                    fileIn.close();
                    break;
                case 13://dificuldade, tipo e assunto
                    fileIn = new Scanner(arqDificuldade);
                    while (fileIn.hasNextLine()){
                        listDificuldade.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqTipo);
                    while (fileIn.hasNextLine()){
                        listTipo.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqAssunto);
                    while (fileIn.hasNextLine()){
                        listAssunto.add(fileIn.nextLine());
                    }
                    Questoes = Compara(listAssunto, listDificuldade);
                    Questoes = Compara (Questoes, listTipo);
                    fileIn.close();
                    break;
                case 14://dificuldade, tipo e materia
                    fileIn = new Scanner(arqDificuldade);
                    while (fileIn.hasNextLine()){
                        listDificuldade.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqTipo);
                    while (fileIn.hasNextLine()){
                        listTipo.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqMateria);
                    while (fileIn.hasNextLine()){
                        listMateria.add(fileIn.nextLine());
                    }
                    Questoes = Compara (listMateria, listTipo);
                    Questoes = Compara (listDificuldade, Questoes);
                    fileIn.close();
                    break;
                case 15://dificudade, tipo ,assunto e materia
                    fileIn = new Scanner(arqDificuldade);
                    while (fileIn.hasNextLine()){
                        listDificuldade.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqTipo);
                    while (fileIn.hasNextLine()){
                        listTipo.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqAssunto);
                    while (fileIn.hasNextLine()){
                        listAssunto.add(fileIn.nextLine());
                    }
                    fileIn.close();
                    fileIn = new Scanner(arqMateria);
                    while (fileIn.hasNextLine()){
                        listMateria.add(fileIn.nextLine());
                    }
                    Questoes = Compara(listAssunto, listDificuldade);
                    Questoes = Compara (Questoes, listTipo);
                    Questoes = Compara (listMateria, Questoes);
                    fileIn.close();
                    break;
        }
        if (Questoes.size()<numero)
            numero=Questoes.size();
        GUI.Busca.encontradas = numero;
        Random gerador = new Random(System.currentTimeMillis());
        int randomico;
        ArrayList<Integer> num = new ArrayList<>();
        int temp;
        while(i<numero){
            temp = gerador.nextInt(Questoes.size());
            if(!num.contains(temp)){
                num.add(temp);
                i++;
            }
        }
        i=0;
        while(i<numero){  
        listquestoes+=Questoes.get(num.get(i))+System.lineSeparator();
        i++;
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Busca.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 22)");
        }
        return listquestoes;
    }
}
