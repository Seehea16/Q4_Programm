package data;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Datenklasse Vorstand.
 * 
 * @author Herbert Seewann
 * @version 5.0
 */
public class Vorstand extends Person {
    
    private String funktion;
    
    /**
     * Konstruktor für Klasse Vorstand.
     * 
     * @param funktion funktion to set
     * @param vorname vorname to set
     * @param nachname nachname to set
     * @param alter alter to set
     */
    public Vorstand(String vorname, String nachname, int alter, String funktion) {
        super(vorname, nachname, alter);
        this.funktion = funktion;
    }

    /**
     * Konstruktor der Klasse Vorstand zum Loaden.
     * 
     * @param currentLine Aktuelle Zeile, in der der Vorstand steht
     */
    public Vorstand(String currentLine) {
        super(currentLine.split(";")[0], currentLine.split(";")[1], 
                Integer.parseInt(currentLine.split(";")[2]));
        this.funktion = currentLine.split(";")[3];
    }

    /**
     * @return current funktion
     */
    public String getFunktion() {
        return funktion;
    }
    
    /**
     * @param funktion funktion to set
     */
    public void setFunktion(String funktion) {
        this.funktion = funktion;
    }

    @Override
    public void writeTo(BufferedWriter writer, boolean newLine) throws IOException {
        super.writeTo(writer, newLine);
        writer.write(this.funktion);
        writer.write(";");
    }
}
