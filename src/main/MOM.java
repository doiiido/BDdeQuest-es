/*
 * Programa inicialmente desenvolvido por Lincoln A. Barbosa a pedido 
 * de Célia de Abreu Barbosa.
 * Deve ser usado para fins exclusivamente educacionais.
 */
package main;

import java.io.File;

/**
 * @author Lincoln
 */
public class MOM {

    /**
     * Inicializando as pastas necessárias
     * @param args
     */
    public static void main(String [] args) {
        File file = new File("Questoes/");
        if(!file.exists())
            file.mkdir();
        file = new File("Indices/Assunto/");
        if(!file.exists())
            file.mkdirs();
        file = new File("Indices/Língua/");
        if(!file.exists())
            file.mkdir();
        file = new File("Buscas/");
        if(!file.exists())
            file.mkdir();
        GUI.Pg1.run();/**< Iniciando programa */
    }
}