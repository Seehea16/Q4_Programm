package model;

/**
 * ENUM SpielerEnum.
 * 
 * @author Herbert Seewann
 * @version 7.0
 */
public enum SpielerEnumNoTraining {
    VORNAME("Vorname"),
    NACHNAME("Nachname"),
    ALTER("Alter"),
    TORESAISON("Tore | Saison"),
    TOREGESAMT("Tore | Gesamt"),
    TRIKOTNUMMER("Trikotnummer"),
    MANNSCHAFT("Mannschaft");
    
    private String name;

    private SpielerEnumNoTraining(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}