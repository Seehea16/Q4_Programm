package data;

/**
 * Datenklasse Vorstand.
 * 
 * @author Herbert Seewann
 * @version 1.0
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
    public Vorstand(String funktion, String vorname, String nachname, int alter) {
        super(vorname, nachname, alter);
        this.funktion = funktion;
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
}
