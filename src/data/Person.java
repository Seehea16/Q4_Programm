package data;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Abstrakte Klasse Person.
 * 
 * @author Herbert Seewann
 * @version 5.0
 */
public abstract class Person {
    
    protected String vorname;
    protected String nachname;
    protected int alter;
    
    /**
     * Konstruktor für Klasse Person.
     * 
     * @param vorname vorname to set
     * @param nachname nachname to set
     * @param alter alter to set
     */
    public Person(String vorname, String nachname, int alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }
    
    /**
     * @return current vorname
     */
    public String getVorname() {
        return vorname;
    }
    
    /**
     * @param vorname vorname to set
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    /**
     * @return current nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * @param nachname nachname to set
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    /**
     * @return current alter
     */
    public int getAlter() {
        return alter;
    }
    
    /**
     * @param alter alter to set
     */
    public void setAlter(int alter) {
        this.alter = alter;
    }

    /**
     * Zum Writen der Datenklassen.
     * 
     * @param writer BufferedWriter
     * @param newLine Shall a newLine be made
     * @throws IOException
     */
    public void writeTo(BufferedWriter writer, boolean newLine) throws IOException {
        if(newLine) {
            writer.newLine();
        }
        writer.write(this.vorname);
        writer.write(";");
        writer.write(this.nachname);
        writer.write(";");
        writer.write(this.alter+"");
        writer.write(";");
    }
}
