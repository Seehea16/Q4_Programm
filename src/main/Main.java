package main;

import gui.MainGUI;

/**
 * Main-Klasse zum Starten des Programms.
 * 
 * @author herbe
 * @version 2.0
 */
public class Main {
    
    /**
     * Programmstartende Main-Methode.
     * 
     * @param args Übergebene Argumente
     */
    public static void main(String[] args) {
        new MainGUI().setVisible(true);
    }
}
