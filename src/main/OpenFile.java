/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Linco
 */


public class OpenFile {
    
    /**abaixo é copia literal de org.apache.commons.lang.SystemUtils*/
    
    private static String getSystemProperty(String property) {
        try {
            return System.getProperty(property);
        } catch (SecurityException ex) {
            // we are not allowed to look at this property
            System.err.println("Caught a SecurityException reading the system property '" + property
                    + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }
    
    public static final String OS_NAME = getSystemProperty("os.name");
    
    private static boolean getOSMatchesName(String osNamePrefix) {
        return isOSNameMatch(OS_NAME, osNamePrefix);
    }
    
     private static final String OS_NAME_WINDOWS_PREFIX = "Windows";
    
    public static final boolean IS_OS_WINDOWS = getOSMatchesName(OS_NAME_WINDOWS_PREFIX);
    
    static boolean isOSNameMatch(String osName, String osNamePrefix) {
        if (osName == null) {
            return false;
        }
        return osName.startsWith(osNamePrefix);
    }
    
    /**final da parte copiada*/
    
    /** detecta se é windows ou não para tentar abrir o resultado com o programa padrã
     * @param path
     * @throws java.io.IOException*/
    public static void openfile(String path) throws IOException{
        File file = new File (path);
        if(!IS_OS_WINDOWS){
            Desktop var = Desktop.getDesktop();
            var.open(file);
        }else{
            Runtime rt=Runtime.getRuntime();
            Process p = rt.exec("rundll32 url.dll,FileProtocolHandler "+file.getAbsolutePath());
        }
    }
}
