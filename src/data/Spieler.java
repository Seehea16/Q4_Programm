package data;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Datenklasse Spieler.
 * 
 * @author Herbert Seewann
 * @version 1.0
 */
public class Spieler extends Person {
    
    private int toreSaison;
    private int toreGesamt;
    private String mannschaft;
    private List<LocalDate> trainings;
    
    /**
     * Konstruktor für Klasse Spieler.
     * 
     * @param vorname vorname to set
     * @param nachname nachname to set
     * @param alter alter to set
     * @param toreSaison toreSaison to set
     * @param toreGesamt toreGesamt to set
     * @param mannschaft mannschaft to set
     */
    public Spieler(String vorname, String nachname, int alter, int toreSaison, int toreGesamt, String mannschaft) {
        super(vorname, nachname, alter);
        this.toreSaison = toreSaison;
        this.toreGesamt = toreGesamt;
        this.mannschaft = mannschaft;
        this.trainings = new LinkedList<>();
    }

    /**
     * @return current toreSaison
     */
    public int getToreSaison() {
        return toreSaison;
    }

    /**
     * @param toreSaison toreSaison to set
     */
    public void setToreSaison(int toreSaison) {
        this.toreSaison = toreSaison;
    }

    /**
     * @return current toreGesamt
     */
    public int getToreGesamt() {
        return toreGesamt;
    }

    /**
     * @param toreGesamt toreGesamt to set
     */
    public void setToreGesamt(int toreGesamt) {
        this.toreGesamt = toreGesamt;
    }

    /**
     * @return current trainings
     */
    public List<LocalDate> getTrainings() {
        return trainings;
    }

    /**
     * @param training training to add
     */
    public void addTraining(LocalDate training) {
        this.trainings.add(training);
    }
    
    /**
     * @param training training to remove
     */
    public void removeTraining(LocalDate training) {
        this.trainings.remove(training);
    }

    /**
     * @param trainings training to set
     */
    public void setTrainings(List<LocalDate> trainings) {
        this.trainings = trainings;
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
