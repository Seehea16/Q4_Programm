package data;

/**
 * Datenklasse Trainer.
 * 
 * @author Herbert Seewann
 * @version 1.0
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
}
