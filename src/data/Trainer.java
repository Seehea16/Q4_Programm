package data;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Datenklasse Trainer.
 * 
 * @author Herbert Seewann
 * @version 5.0
 */
public class Trainer extends Person {
    
    private String mannschaft;
    
    /**
     * Konstruktor für Klasse Trainer.
     * 
     * @param vorname vorname to set
     * @param nachname nachname to set
     * @param alter alter to set
     * @param mannschaft mannschaft to set
     */
    public Trainer(String vorname, String nachname, int alter, String mannschaft) {
        super(vorname, nachname, alter);
        this.mannschaft = mannschaft;
    }

    /**
     * Konstruktor der Klasse Trainer zum Loaden.
     * 
     * @param currentLine Aktuelle Zeile, in der der Trainer steht
     */
    public Trainer(String currentLine) {
        super(currentLine.split(";")[0], currentLine.split(";")[1], 
                Integer.parseInt(currentLine.split(";")[2]));
        this.mannschaft = currentLine.split(";")[3];
    }

    /**
     * @return current mannschaft
     */
    public String getMannschaft() {
        return mannschaft;
    }

    /**
     * @param mannschaft mannschaft to set
     */
    public void setMannschaft(String mannschaft) {
        this.mannschaft = mannschaft;
    }

    @Override
    public void writeTo(BufferedWriter writer, boolean newLine) throws IOException {
        super.writeTo(writer, newLine);
        writer.write(this.mannschaft);
        writer.write(";");
    }
}
