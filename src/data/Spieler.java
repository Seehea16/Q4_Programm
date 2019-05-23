package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * Datenklasse Spieler.
 * 
 * @author Herbert Seewann
 * @version 7.0
 */
public class Spieler extends Person {
    
    private int toreSaison;
    private int toreGesamt;
    private int trikotNummer;
    private String mannschaft;
    private List<LocalDate> trainings;
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    
    /**
     * Konstruktor für Klasse Spieler.
     * 
     * @param vorname vorname to set
     * @param nachname nachname to set
     * @param alter alter to set
     * @param toreSaison toreSaison to set
     * @param toreGesamt toreGesamt to set
     * @param trikotNummer trikoNummer to set
     * @param mannschaft mannschaft to set
     */
    public Spieler(String vorname, String nachname, int alter, int toreSaison, 
            int toreGesamt, int trikotNummer, String mannschaft) {
        super(vorname, nachname, alter);
        this.setToreSaison(toreSaison);
        this.setToreGesamt(toreGesamt);
        this.setTrikotNummer(trikotNummer);
        this.mannschaft = mannschaft;
        this.trainings = new LinkedList<>();
    }

    /**
     * Konstruktor der Klasse Spieler zum Loaden.
     * 
     * @param currentLine Aktuelle Zeile, in der der Spieler steht
     */
    public Spieler(String currentLine) {
        super(currentLine.split(";")[0], currentLine.split(";")[1], 
                Integer.parseInt(currentLine.split(";")[2]));
        this.setToreSaison(Integer.parseInt(currentLine.split(";")[3]));
        this.setToreGesamt(Integer.parseInt(currentLine.split(";")[4]));
        this.setTrikotNummer(Integer.parseInt(currentLine.split(";")[5]));
        this.mannschaft = currentLine.split(";")[6];
        this.trainings = new LinkedList<>();
        for(int i = 7; i < currentLine.split(";").length; i++) {
            this.trainings.add(LocalDate.parse(currentLine.split(";")[i], DTF));
        }
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
        if(toreSaison > toreGesamt) {
            toreGesamt = toreSaison;
        }
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
        if(toreGesamt < toreSaison) {
            toreSaison = toreGesamt;
        }
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
    
    /**
     * @return current trikotNummer
     */
    public int getTrikotNummer() {
        return trikotNummer;
    }
    
    /**
     * @param trikotNummer trikotNummer to set
     */
    public void setTrikotNummer(int trikotNummer) {
        this.trikotNummer = trikotNummer;
    }

    @Override
    public void writeTo(BufferedWriter writer, boolean newLine) throws IOException {
        super.writeTo(writer, newLine);
        writer.write(this.toreSaison+"");
        writer.write(";");
        writer.write(this.toreGesamt+"");
        writer.write(";");
        writer.write(this.trikotNummer+"");
        writer.write(";");
        writer.write(this.mannschaft);
        writer.write(";");
        for(LocalDate ld : this.trainings) {
            writer.write(ld.format(DTF));
            writer.write(";");
        }
    }
}